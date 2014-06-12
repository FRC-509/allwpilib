// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: subscribe.proto

package gazebo.msgs;

public final class GzSubscribe {
  private GzSubscribe() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
  }
  public interface SubscribeOrBuilder
      extends com.google.protobuf.MessageOrBuilder {

    // required string topic = 1;
    /**
     * <code>required string topic = 1;</code>
     */
    boolean hasTopic();
    /**
     * <code>required string topic = 1;</code>
     */
    java.lang.String getTopic();
    /**
     * <code>required string topic = 1;</code>
     */
    com.google.protobuf.ByteString
        getTopicBytes();

    // required string host = 2;
    /**
     * <code>required string host = 2;</code>
     */
    boolean hasHost();
    /**
     * <code>required string host = 2;</code>
     */
    java.lang.String getHost();
    /**
     * <code>required string host = 2;</code>
     */
    com.google.protobuf.ByteString
        getHostBytes();

    // required uint32 port = 3;
    /**
     * <code>required uint32 port = 3;</code>
     */
    boolean hasPort();
    /**
     * <code>required uint32 port = 3;</code>
     */
    int getPort();

    // required string msg_type = 4;
    /**
     * <code>required string msg_type = 4;</code>
     */
    boolean hasMsgType();
    /**
     * <code>required string msg_type = 4;</code>
     */
    java.lang.String getMsgType();
    /**
     * <code>required string msg_type = 4;</code>
     */
    com.google.protobuf.ByteString
        getMsgTypeBytes();

    // optional bool latching = 5 [default = true];
    /**
     * <code>optional bool latching = 5 [default = true];</code>
     */
    boolean hasLatching();
    /**
     * <code>optional bool latching = 5 [default = true];</code>
     */
    boolean getLatching();
  }
  /**
   * Protobuf type {@code gazebo.msgs.Subscribe}
   */
  public static final class Subscribe extends
      com.google.protobuf.GeneratedMessage
      implements SubscribeOrBuilder {
    // Use Subscribe.newBuilder() to construct.
    private Subscribe(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
      super(builder);
      this.unknownFields = builder.getUnknownFields();
    }
    private Subscribe(boolean noInit) { this.unknownFields = com.google.protobuf.UnknownFieldSet.getDefaultInstance(); }

    private static final Subscribe defaultInstance;
    public static Subscribe getDefaultInstance() {
      return defaultInstance;
    }

    public Subscribe getDefaultInstanceForType() {
      return defaultInstance;
    }

    private final com.google.protobuf.UnknownFieldSet unknownFields;
    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
      return this.unknownFields;
    }
    private Subscribe(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      initFields();
      int mutable_bitField0_ = 0;
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!parseUnknownField(input, unknownFields,
                                     extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
            case 10: {
              bitField0_ |= 0x00000001;
              topic_ = input.readBytes();
              break;
            }
            case 18: {
              bitField0_ |= 0x00000002;
              host_ = input.readBytes();
              break;
            }
            case 24: {
              bitField0_ |= 0x00000004;
              port_ = input.readUInt32();
              break;
            }
            case 34: {
              bitField0_ |= 0x00000008;
              msgType_ = input.readBytes();
              break;
            }
            case 40: {
              bitField0_ |= 0x00000010;
              latching_ = input.readBool();
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e.getMessage()).setUnfinishedMessage(this);
      } finally {
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return gazebo.msgs.GzSubscribe.internal_static_gazebo_msgs_Subscribe_descriptor;
    }

    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return gazebo.msgs.GzSubscribe.internal_static_gazebo_msgs_Subscribe_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              gazebo.msgs.GzSubscribe.Subscribe.class, gazebo.msgs.GzSubscribe.Subscribe.Builder.class);
    }

    public static com.google.protobuf.Parser<Subscribe> PARSER =
        new com.google.protobuf.AbstractParser<Subscribe>() {
      public Subscribe parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new Subscribe(input, extensionRegistry);
      }
    };

    @java.lang.Override
    public com.google.protobuf.Parser<Subscribe> getParserForType() {
      return PARSER;
    }

    private int bitField0_;
    // required string topic = 1;
    public static final int TOPIC_FIELD_NUMBER = 1;
    private java.lang.Object topic_;
    /**
     * <code>required string topic = 1;</code>
     */
    public boolean hasTopic() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>required string topic = 1;</code>
     */
    public java.lang.String getTopic() {
      java.lang.Object ref = topic_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          topic_ = s;
        }
        return s;
      }
    }
    /**
     * <code>required string topic = 1;</code>
     */
    public com.google.protobuf.ByteString
        getTopicBytes() {
      java.lang.Object ref = topic_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        topic_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    // required string host = 2;
    public static final int HOST_FIELD_NUMBER = 2;
    private java.lang.Object host_;
    /**
     * <code>required string host = 2;</code>
     */
    public boolean hasHost() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <code>required string host = 2;</code>
     */
    public java.lang.String getHost() {
      java.lang.Object ref = host_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          host_ = s;
        }
        return s;
      }
    }
    /**
     * <code>required string host = 2;</code>
     */
    public com.google.protobuf.ByteString
        getHostBytes() {
      java.lang.Object ref = host_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        host_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    // required uint32 port = 3;
    public static final int PORT_FIELD_NUMBER = 3;
    private int port_;
    /**
     * <code>required uint32 port = 3;</code>
     */
    public boolean hasPort() {
      return ((bitField0_ & 0x00000004) == 0x00000004);
    }
    /**
     * <code>required uint32 port = 3;</code>
     */
    public int getPort() {
      return port_;
    }

    // required string msg_type = 4;
    public static final int MSG_TYPE_FIELD_NUMBER = 4;
    private java.lang.Object msgType_;
    /**
     * <code>required string msg_type = 4;</code>
     */
    public boolean hasMsgType() {
      return ((bitField0_ & 0x00000008) == 0x00000008);
    }
    /**
     * <code>required string msg_type = 4;</code>
     */
    public java.lang.String getMsgType() {
      java.lang.Object ref = msgType_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          msgType_ = s;
        }
        return s;
      }
    }
    /**
     * <code>required string msg_type = 4;</code>
     */
    public com.google.protobuf.ByteString
        getMsgTypeBytes() {
      java.lang.Object ref = msgType_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        msgType_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    // optional bool latching = 5 [default = true];
    public static final int LATCHING_FIELD_NUMBER = 5;
    private boolean latching_;
    /**
     * <code>optional bool latching = 5 [default = true];</code>
     */
    public boolean hasLatching() {
      return ((bitField0_ & 0x00000010) == 0x00000010);
    }
    /**
     * <code>optional bool latching = 5 [default = true];</code>
     */
    public boolean getLatching() {
      return latching_;
    }

    private void initFields() {
      topic_ = "";
      host_ = "";
      port_ = 0;
      msgType_ = "";
      latching_ = true;
    }
    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized != -1) return isInitialized == 1;

      if (!hasTopic()) {
        memoizedIsInitialized = 0;
        return false;
      }
      if (!hasHost()) {
        memoizedIsInitialized = 0;
        return false;
      }
      if (!hasPort()) {
        memoizedIsInitialized = 0;
        return false;
      }
      if (!hasMsgType()) {
        memoizedIsInitialized = 0;
        return false;
      }
      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      getSerializedSize();
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        output.writeBytes(1, getTopicBytes());
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        output.writeBytes(2, getHostBytes());
      }
      if (((bitField0_ & 0x00000004) == 0x00000004)) {
        output.writeUInt32(3, port_);
      }
      if (((bitField0_ & 0x00000008) == 0x00000008)) {
        output.writeBytes(4, getMsgTypeBytes());
      }
      if (((bitField0_ & 0x00000010) == 0x00000010)) {
        output.writeBool(5, latching_);
      }
      getUnknownFields().writeTo(output);
    }

    private int memoizedSerializedSize = -1;
    public int getSerializedSize() {
      int size = memoizedSerializedSize;
      if (size != -1) return size;

      size = 0;
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(1, getTopicBytes());
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(2, getHostBytes());
      }
      if (((bitField0_ & 0x00000004) == 0x00000004)) {
        size += com.google.protobuf.CodedOutputStream
          .computeUInt32Size(3, port_);
      }
      if (((bitField0_ & 0x00000008) == 0x00000008)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(4, getMsgTypeBytes());
      }
      if (((bitField0_ & 0x00000010) == 0x00000010)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBoolSize(5, latching_);
      }
      size += getUnknownFields().getSerializedSize();
      memoizedSerializedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    @java.lang.Override
    protected java.lang.Object writeReplace()
        throws java.io.ObjectStreamException {
      return super.writeReplace();
    }

    public static gazebo.msgs.GzSubscribe.Subscribe parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static gazebo.msgs.GzSubscribe.Subscribe parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static gazebo.msgs.GzSubscribe.Subscribe parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static gazebo.msgs.GzSubscribe.Subscribe parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static gazebo.msgs.GzSubscribe.Subscribe parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static gazebo.msgs.GzSubscribe.Subscribe parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }
    public static gazebo.msgs.GzSubscribe.Subscribe parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input);
    }
    public static gazebo.msgs.GzSubscribe.Subscribe parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input, extensionRegistry);
    }
    public static gazebo.msgs.GzSubscribe.Subscribe parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static gazebo.msgs.GzSubscribe.Subscribe parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }

    public static Builder newBuilder() { return Builder.create(); }
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder(gazebo.msgs.GzSubscribe.Subscribe prototype) {
      return newBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() { return newBuilder(this); }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessage.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code gazebo.msgs.Subscribe}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessage.Builder<Builder>
       implements gazebo.msgs.GzSubscribe.SubscribeOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return gazebo.msgs.GzSubscribe.internal_static_gazebo_msgs_Subscribe_descriptor;
      }

      protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return gazebo.msgs.GzSubscribe.internal_static_gazebo_msgs_Subscribe_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                gazebo.msgs.GzSubscribe.Subscribe.class, gazebo.msgs.GzSubscribe.Subscribe.Builder.class);
      }

      // Construct using gazebo.msgs.GzSubscribe.Subscribe.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessage.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders) {
        }
      }
      private static Builder create() {
        return new Builder();
      }

      public Builder clear() {
        super.clear();
        topic_ = "";
        bitField0_ = (bitField0_ & ~0x00000001);
        host_ = "";
        bitField0_ = (bitField0_ & ~0x00000002);
        port_ = 0;
        bitField0_ = (bitField0_ & ~0x00000004);
        msgType_ = "";
        bitField0_ = (bitField0_ & ~0x00000008);
        latching_ = true;
        bitField0_ = (bitField0_ & ~0x00000010);
        return this;
      }

      public Builder clone() {
        return create().mergeFrom(buildPartial());
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return gazebo.msgs.GzSubscribe.internal_static_gazebo_msgs_Subscribe_descriptor;
      }

      public gazebo.msgs.GzSubscribe.Subscribe getDefaultInstanceForType() {
        return gazebo.msgs.GzSubscribe.Subscribe.getDefaultInstance();
      }

      public gazebo.msgs.GzSubscribe.Subscribe build() {
        gazebo.msgs.GzSubscribe.Subscribe result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public gazebo.msgs.GzSubscribe.Subscribe buildPartial() {
        gazebo.msgs.GzSubscribe.Subscribe result = new gazebo.msgs.GzSubscribe.Subscribe(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
          to_bitField0_ |= 0x00000001;
        }
        result.topic_ = topic_;
        if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
          to_bitField0_ |= 0x00000002;
        }
        result.host_ = host_;
        if (((from_bitField0_ & 0x00000004) == 0x00000004)) {
          to_bitField0_ |= 0x00000004;
        }
        result.port_ = port_;
        if (((from_bitField0_ & 0x00000008) == 0x00000008)) {
          to_bitField0_ |= 0x00000008;
        }
        result.msgType_ = msgType_;
        if (((from_bitField0_ & 0x00000010) == 0x00000010)) {
          to_bitField0_ |= 0x00000010;
        }
        result.latching_ = latching_;
        result.bitField0_ = to_bitField0_;
        onBuilt();
        return result;
      }

      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof gazebo.msgs.GzSubscribe.Subscribe) {
          return mergeFrom((gazebo.msgs.GzSubscribe.Subscribe)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(gazebo.msgs.GzSubscribe.Subscribe other) {
        if (other == gazebo.msgs.GzSubscribe.Subscribe.getDefaultInstance()) return this;
        if (other.hasTopic()) {
          bitField0_ |= 0x00000001;
          topic_ = other.topic_;
          onChanged();
        }
        if (other.hasHost()) {
          bitField0_ |= 0x00000002;
          host_ = other.host_;
          onChanged();
        }
        if (other.hasPort()) {
          setPort(other.getPort());
        }
        if (other.hasMsgType()) {
          bitField0_ |= 0x00000008;
          msgType_ = other.msgType_;
          onChanged();
        }
        if (other.hasLatching()) {
          setLatching(other.getLatching());
        }
        this.mergeUnknownFields(other.getUnknownFields());
        return this;
      }

      public final boolean isInitialized() {
        if (!hasTopic()) {
          
          return false;
        }
        if (!hasHost()) {
          
          return false;
        }
        if (!hasPort()) {
          
          return false;
        }
        if (!hasMsgType()) {
          
          return false;
        }
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        gazebo.msgs.GzSubscribe.Subscribe parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (gazebo.msgs.GzSubscribe.Subscribe) e.getUnfinishedMessage();
          throw e;
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      // required string topic = 1;
      private java.lang.Object topic_ = "";
      /**
       * <code>required string topic = 1;</code>
       */
      public boolean hasTopic() {
        return ((bitField0_ & 0x00000001) == 0x00000001);
      }
      /**
       * <code>required string topic = 1;</code>
       */
      public java.lang.String getTopic() {
        java.lang.Object ref = topic_;
        if (!(ref instanceof java.lang.String)) {
          java.lang.String s = ((com.google.protobuf.ByteString) ref)
              .toStringUtf8();
          topic_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>required string topic = 1;</code>
       */
      public com.google.protobuf.ByteString
          getTopicBytes() {
        java.lang.Object ref = topic_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          topic_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>required string topic = 1;</code>
       */
      public Builder setTopic(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000001;
        topic_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required string topic = 1;</code>
       */
      public Builder clearTopic() {
        bitField0_ = (bitField0_ & ~0x00000001);
        topic_ = getDefaultInstance().getTopic();
        onChanged();
        return this;
      }
      /**
       * <code>required string topic = 1;</code>
       */
      public Builder setTopicBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000001;
        topic_ = value;
        onChanged();
        return this;
      }

      // required string host = 2;
      private java.lang.Object host_ = "";
      /**
       * <code>required string host = 2;</code>
       */
      public boolean hasHost() {
        return ((bitField0_ & 0x00000002) == 0x00000002);
      }
      /**
       * <code>required string host = 2;</code>
       */
      public java.lang.String getHost() {
        java.lang.Object ref = host_;
        if (!(ref instanceof java.lang.String)) {
          java.lang.String s = ((com.google.protobuf.ByteString) ref)
              .toStringUtf8();
          host_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>required string host = 2;</code>
       */
      public com.google.protobuf.ByteString
          getHostBytes() {
        java.lang.Object ref = host_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          host_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>required string host = 2;</code>
       */
      public Builder setHost(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000002;
        host_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required string host = 2;</code>
       */
      public Builder clearHost() {
        bitField0_ = (bitField0_ & ~0x00000002);
        host_ = getDefaultInstance().getHost();
        onChanged();
        return this;
      }
      /**
       * <code>required string host = 2;</code>
       */
      public Builder setHostBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000002;
        host_ = value;
        onChanged();
        return this;
      }

      // required uint32 port = 3;
      private int port_ ;
      /**
       * <code>required uint32 port = 3;</code>
       */
      public boolean hasPort() {
        return ((bitField0_ & 0x00000004) == 0x00000004);
      }
      /**
       * <code>required uint32 port = 3;</code>
       */
      public int getPort() {
        return port_;
      }
      /**
       * <code>required uint32 port = 3;</code>
       */
      public Builder setPort(int value) {
        bitField0_ |= 0x00000004;
        port_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required uint32 port = 3;</code>
       */
      public Builder clearPort() {
        bitField0_ = (bitField0_ & ~0x00000004);
        port_ = 0;
        onChanged();
        return this;
      }

      // required string msg_type = 4;
      private java.lang.Object msgType_ = "";
      /**
       * <code>required string msg_type = 4;</code>
       */
      public boolean hasMsgType() {
        return ((bitField0_ & 0x00000008) == 0x00000008);
      }
      /**
       * <code>required string msg_type = 4;</code>
       */
      public java.lang.String getMsgType() {
        java.lang.Object ref = msgType_;
        if (!(ref instanceof java.lang.String)) {
          java.lang.String s = ((com.google.protobuf.ByteString) ref)
              .toStringUtf8();
          msgType_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>required string msg_type = 4;</code>
       */
      public com.google.protobuf.ByteString
          getMsgTypeBytes() {
        java.lang.Object ref = msgType_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          msgType_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>required string msg_type = 4;</code>
       */
      public Builder setMsgType(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000008;
        msgType_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required string msg_type = 4;</code>
       */
      public Builder clearMsgType() {
        bitField0_ = (bitField0_ & ~0x00000008);
        msgType_ = getDefaultInstance().getMsgType();
        onChanged();
        return this;
      }
      /**
       * <code>required string msg_type = 4;</code>
       */
      public Builder setMsgTypeBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000008;
        msgType_ = value;
        onChanged();
        return this;
      }

      // optional bool latching = 5 [default = true];
      private boolean latching_ = true;
      /**
       * <code>optional bool latching = 5 [default = true];</code>
       */
      public boolean hasLatching() {
        return ((bitField0_ & 0x00000010) == 0x00000010);
      }
      /**
       * <code>optional bool latching = 5 [default = true];</code>
       */
      public boolean getLatching() {
        return latching_;
      }
      /**
       * <code>optional bool latching = 5 [default = true];</code>
       */
      public Builder setLatching(boolean value) {
        bitField0_ |= 0x00000010;
        latching_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional bool latching = 5 [default = true];</code>
       */
      public Builder clearLatching() {
        bitField0_ = (bitField0_ & ~0x00000010);
        latching_ = true;
        onChanged();
        return this;
      }

      // @@protoc_insertion_point(builder_scope:gazebo.msgs.Subscribe)
    }

    static {
      defaultInstance = new Subscribe(true);
      defaultInstance.initFields();
    }

    // @@protoc_insertion_point(class_scope:gazebo.msgs.Subscribe)
  }

  private static com.google.protobuf.Descriptors.Descriptor
    internal_static_gazebo_msgs_Subscribe_descriptor;
  private static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_gazebo_msgs_Subscribe_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\017subscribe.proto\022\013gazebo.msgs\"`\n\tSubscr" +
      "ibe\022\r\n\005topic\030\001 \002(\t\022\014\n\004host\030\002 \002(\t\022\014\n\004port" +
      "\030\003 \002(\r\022\020\n\010msg_type\030\004 \002(\t\022\026\n\010latching\030\005 \001" +
      "(\010:\004trueB\rB\013GzSubscribe"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
      new com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner() {
        public com.google.protobuf.ExtensionRegistry assignDescriptors(
            com.google.protobuf.Descriptors.FileDescriptor root) {
          descriptor = root;
          internal_static_gazebo_msgs_Subscribe_descriptor =
            getDescriptor().getMessageTypes().get(0);
          internal_static_gazebo_msgs_Subscribe_fieldAccessorTable = new
            com.google.protobuf.GeneratedMessage.FieldAccessorTable(
              internal_static_gazebo_msgs_Subscribe_descriptor,
              new java.lang.String[] { "Topic", "Host", "Port", "MsgType", "Latching", });
          return null;
        }
      };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
  }

  // @@protoc_insertion_point(outer_class_scope)
}
