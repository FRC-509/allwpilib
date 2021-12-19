// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

#include <memory>
#include <string_view>

#ifndef _WIN32
#include <arpa/inet.h>
#endif

#include <fmt/format.h>
#include <glass/MainMenuBar.h>
#include <glass/Context.h>
#include <glass/Storage.h>
#include <glass/Window.h>
#include <glass/WindowManager.h>
#include <glass/other/Log.h>
#include <imgui.h>
#include <libssh/libssh.h>
#include <wpi/Logger.h>
#include <wpi/fs.h>
#include <wpigui.h>
#include <unordered_map>
#include <mutex>
#include "wpi/SmallString.h"
#include "DeploySession.h"
#include "wpi/MulticastServiceResolver.h"

namespace gui = wpi::gui;

const char* GetWPILibVersion();

#define GLFWAPI extern "C"
GLFWAPI void glfwGetWindowSize(GLFWwindow* window, int* width, int* height);
#define GLFW_DONT_CARE -1
GLFWAPI void glfwSetWindowSizeLimits(GLFWwindow* window, int minwidth,
                                     int minheight, int maxwidth,
                                     int maxheight);
GLFWAPI void glfwSetWindowSize(GLFWwindow* window, int width, int height);

struct TeamNumberRefHolder {
  explicit TeamNumberRefHolder(glass::Storage& storage)
      : teamNumber{storage.GetInt("TeamNumber", 0)} {}
  int& teamNumber;
};

static std::unique_ptr<TeamNumberRefHolder> teamNumberRef;
static std::unordered_map<std::string, std::pair<unsigned int, std::string>>
    foundDevices;
static wpi::Logger logger;
static sysid::DeploySession deploySession{logger};
static std::unique_ptr<wpi::MulticastServiceResolver> multicastResolver;
static glass::MainMenuBar gMainMenu;

static void FindDevices() {
  WPI_EventHandle resolveEvent = multicastResolver->GetEventHandle();

  bool timedOut = 0;
  if (wpi::WaitForObject(resolveEvent, 0, &timedOut)) {
    auto allData = multicastResolver->GetData();

    for (auto&& data : allData) {
      // search for MAC
      auto macKey =
          std::find_if(data.txt.begin(), data.txt.end(),
                       [](const auto& a) { return a.first == "MAC"; });
      if (macKey != data.txt.end()) {
        auto& mac = macKey->second;
        foundDevices[mac] = std::make_pair(data.ipv4Address, data.hostName);
      }
    }
  }
}

static int minWidth = 400;

static void DisplayGui() {
  int& teamNumber = teamNumberRef->teamNumber;
  FindDevices();

  ImGui::GetStyle().WindowRounding = 0;

  // fill entire OS window with this window
  ImGui::SetNextWindowPos(ImVec2(0, 0));
  int width, height;
  glfwGetWindowSize(gui::GetSystemWindow(), &width, &height);

  ImGui::SetNextWindowSize(ImVec2(width, height));

  ImGui::Begin("Entries", nullptr,
               ImGuiWindowFlags_NoTitleBar | ImGuiWindowFlags_MenuBar |
                   ImGuiWindowFlags_NoResize | ImGuiWindowFlags_NoMove |
                   ImGuiWindowFlags_NoCollapse);

  ImGui::BeginMenuBar();
  gMainMenu.WorkspaceMenu();
  gui::EmitViewMenu();

  bool about = false;
  if (ImGui::BeginMenu("Info")) {
    if (ImGui::MenuItem("About")) {
      about = true;
    }
    ImGui::EndMenu();
  }
  ImGui::EndMenuBar();

  if (about) {
    ImGui::OpenPopup("About");
  }
  if (ImGui::BeginPopupModal("About")) {
    ImGui::Text("roboRIO Team Number Setter");
    ImGui::Separator();
    ImGui::Text("v%s", GetWPILibVersion());
    ImGui::Separator();
    ImGui::Text("Has mDNS Implementation: %d",
                static_cast<int>(multicastResolver->HasImplementation()));
    ImGui::Separator();
    ImGui::Text("Save location: %s", glass::GetStorageDir().c_str());
    if (ImGui::Button("Close")) {
      ImGui::CloseCurrentPopup();
    }
    ImGui::EndPopup();
  }

  if (multicastResolver->HasImplementation()) {
    ImGui::InputInt("Team Number", &teamNumber);

    if (teamNumber < 0) {
      teamNumber = 0;
    }

    int nameWidth = ImGui::CalcTextSize("roboRIO2-0000-FRC.local. ").x;
    int macWidth = ImGui::CalcTextSize("88:88:88:88:88:88").x;
    int ipAddressWidth = ImGui::CalcTextSize("255.255.255.255").x;
    int setWidth = ImGui::CalcTextSize(" Set Team To 99999 ").x;
    int blinkWidth = ImGui::CalcTextSize(" Blink ").x;
    int rebootWidth = ImGui::CalcTextSize(" Reboot ").x;

    minWidth = nameWidth + macWidth + ipAddressWidth + setWidth + blinkWidth +
               rebootWidth + 100;

    std::string setString = fmt::format("Set team to {}", teamNumber);

    if (ImGui::BeginTable("Table", 6)) {
      ImGui::TableSetupColumn(
          "Name",
          ImGuiTableColumnFlags_NoResize | ImGuiTableColumnFlags_WidthFixed,
          nameWidth);
      ImGui::TableSetupColumn(
          "MAC Address",
          ImGuiTableColumnFlags_NoResize | ImGuiTableColumnFlags_WidthFixed,
          macWidth);
      ImGui::TableSetupColumn(
          "IP Address",
          ImGuiTableColumnFlags_NoResize | ImGuiTableColumnFlags_WidthFixed,
          ipAddressWidth);
      ImGui::TableSetupColumn(
          "Set",
          ImGuiTableColumnFlags_NoResize | ImGuiTableColumnFlags_WidthFixed,
          setWidth);
      ImGui::TableSetupColumn(
          "Blink",
          ImGuiTableColumnFlags_NoResize | ImGuiTableColumnFlags_WidthFixed,
          blinkWidth);
      ImGui::TableSetupColumn(
          "Reboot",
          ImGuiTableColumnFlags_NoResize | ImGuiTableColumnFlags_WidthFixed,
          rebootWidth);
      ImGui::TableHeadersRow();

      for (auto&& i : foundDevices) {
        ImGui::TableNextRow();
        ImGui::TableNextColumn();
        ImGui::Text("%s", i.second.second.c_str());
        ImGui::TableNextColumn();
        ImGui::Text("%s", i.first.c_str());
        ImGui::TableNextColumn();
        struct in_addr in;
        in.s_addr = i.second.first;
        ImGui::Text("%s", inet_ntoa(in));
        ImGui::TableNextColumn();
        std::future<int>* future = deploySession.GetFuture(i.first);
        ImGui::PushID(i.first.c_str());
        if (future) {
          ImGui::Button("Deploying");
          ImGui::TableNextColumn();
          ImGui::TableNextColumn();
          const auto fs = future->wait_for(std::chrono::seconds(0));
          if (fs == std::future_status::ready) {
            deploySession.DestroyFuture(i.first);
          }
        } else {
          if (ImGui::Button(setString.c_str())) {
            deploySession.ChangeTeamNumber(i.first, teamNumber, i.second.first);
          }
          ImGui::TableNextColumn();
          if (ImGui::Button("Blink")) {
            deploySession.Blink(i.first, i.second.first);
          }
          ImGui::TableNextColumn();
          if (ImGui::Button("Reboot")) {
            deploySession.Reboot(i.first, i.second.first);
          }
        }
        ImGui::PopID();
      }

      ImGui::EndTable();
    }

    ImGui::Columns(6, "Devices");

    // TODO make columns better
  } else {
    // Missing MDNS Implementation
    ImGui::Text("mDNS Implementation is missing.");
#ifdef _WIN32
    ImGui::Text("Windows 10 1809 or newer is required for this tool");
#else
    ImGui::Text("avahi-client 3 and avahi-core 3 are required for this tool");
    ImGui::Text(
        "Install libavahi-client3 and libavahi-core3 from your package "
        "manager");
#endif
  }
  ImGui::Columns();
  ImGui::End();

  glfwSetWindowSizeLimits(gui::GetSystemWindow(), minWidth, 200, GLFW_DONT_CARE,
                          GLFW_DONT_CARE);
  if (width < minWidth) {
    width = minWidth;
    glfwSetWindowSize(gui::GetSystemWindow(), width, height);
  }
}

void Application(std::string_view saveDir) {
  gui::CreateContext();
  glass::CreateContext();

  glass::SetStorageName("roborioteamnumbersetter");
  glass::SetStorageDir(saveDir.empty() ? gui::GetPlatformSaveFileDir()
                                       : saveDir);

  ssh_init();

  teamNumberRef =
      std::make_unique<TeamNumberRefHolder>(glass::GetStorageRoot());

  multicastResolver =
      std::make_unique<wpi::MulticastServiceResolver>("_ni._tcp");
  multicastResolver->Start();

  gui::AddLateExecute(DisplayGui);
  gui::Initialize("roboRIO Team Number Setter", 600, 400);

  gui::Main();
  multicastResolver->Stop();
  multicastResolver = nullptr;

  glass::DestroyContext();
  gui::DestroyContext();
}