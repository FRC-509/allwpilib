/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.							  */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in $(WIND_BASE)/WPILib.  */
/*----------------------------------------------------------------------------*/

#include "SimpleRobot.h"

#include <stdio.h>
#include <unistd.h>

// #include "DriverStation.h"
#include "Timer.h"
#include "SmartDashboard/SmartDashboard.h"
#include "LiveWindow/LiveWindow.h"
#include "networktables/NetworkTable.h"

SimpleRobot::SimpleRobot()
	: m_robotMainOverridden (true)
{
}

/**
 * Robot-wide initialization code should go here.
 * 
 * Programmers should override this method for default Robot-wide initialization which will
 * be called each time the robot enters the disabled state.
 */
void SimpleRobot::RobotInit()
{
	printf("Default %s() method... Override me!\n", __FUNCTION__);
}

/**
 * Disabled should go here.
 * Programmers should override this method to run code that should run while the field is
 * disabled.
 */
void SimpleRobot::Disabled()
{
	printf("Default %s() method... Override me!\n", __FUNCTION__);
}

/**
 * Autonomous should go here.
 * Programmers should override this method to run code that should run while the field is
 * in the autonomous period. This will be called once each time the robot enters the
 * autonomous state.
 */
void SimpleRobot::Autonomous()
{
	printf("Default %s() method... Override me!\n", __FUNCTION__);
}

/**
 * Operator control (tele-operated) code should go here.
 * Programmers should override this method to run code that should run while the field is
 * in the Operator Control (tele-operated) period. This is called once each time the robot
 * enters the teleop state.
 */
void SimpleRobot::OperatorControl()
{
	printf("Default %s() method... Override me!\n", __FUNCTION__);
}

/**
 * Test program should go here.
 * Programmers should override this method to run code that executes while the robot is
 * in test mode. This will be called once whenever the robot enters test mode
 */
void SimpleRobot::Test()
{
	printf("Default %s() method... Override me!\n", __FUNCTION__);
}

/**
 * Robot main program for free-form programs.
 * 
 * This should be overridden by user subclasses if the intent is to not use the Autonomous() and
 * OperatorControl() methods. In that case, the program is responsible for sensing when to run
 * the autonomous and operator control functions in their program.
 * 
 * This method will be called immediately after the constructor is called. If it has not been
 * overridden by a user subclass (i.e. the default version runs), then the Autonomous() and
 * OperatorControl() methods will be called.
 */
void SimpleRobot::RobotMain()
{
	m_robotMainOverridden = false;
}

/**
 * Start a competition.
 * This code needs to track the order of the field starting to ensure that everything happens
 * in the right order. Repeatedly run the correct method, either Autonomous or OperatorControl
 * or Test when the robot is enabled. After running the correct method, wait for some state to
 * change, either the other mode starts or the robot is disabled. Then go back and wait for the
 * robot to be enabled again.
 */
void SimpleRobot::StartCompetition()
{
    LiveWindow *lw = LiveWindow::GetInstance();

  	SmartDashboard::init();
	NetworkTable::GetTable("LiveWindow")->GetSubTable("~STATUS~")->PutBoolean("LW Enabled", false);
  
	RobotMain();
	
	if (!m_robotMainOverridden)
	{
		// first and one-time initialization
		//lw->SetEnabled(false);
		RobotInit();

		while (true)
		{
			if (IsDisabled())
			{
				// TODO: m_ds->InDisabled(true);
				Disabled();
				// TODO: m_ds->InDisabled(false);
				while (IsDisabled()) sleep(1); //m_ds->WaitForData();
			}
			else if (IsAutonomous())
			{
				// TODO: m_ds->InAutonomous(true);
				Autonomous();
				// TODO: m_ds->InAutonomous(false);
				while (IsAutonomous() && IsEnabled()) sleep(1); //m_ds->WaitForData();
			}
            else if (IsTest())
            {
            	// lw->SetEnabled(true);
            	// TODO: m_ds->InTest(true);
                Test();
                // TODO: m_ds->InTest(false);
                while (IsTest() && IsEnabled()) sleep(1); //m_ds->WaitForData();
                //lw->SetEnabled(false);
            }
			else
			{
				// TODO: m_ds->InOperatorControl(true);
				OperatorControl();
				// TODO: m_ds->InOperatorControl(false);
				while (IsOperatorControl() && IsEnabled()) sleep(1); //m_ds->WaitForData();
			}
		}
	}
}
