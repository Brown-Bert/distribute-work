package org.example.helloWorld;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 *定义服务
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.11.0)",
    comments = "Source: HelloWorld.proto")
public final class OperateSelectGrpc {

  private OperateSelectGrpc() {}

  public static final String SERVICE_NAME = "OperateSelect";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCalculateMethod()} instead. 
  public static final io.grpc.MethodDescriptor<org.example.helloWorld.RequestSelect,
      org.example.helloWorld.Response> METHOD_CALCULATE = getCalculateMethodHelper();

  private static volatile io.grpc.MethodDescriptor<org.example.helloWorld.RequestSelect,
      org.example.helloWorld.Response> getCalculateMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<org.example.helloWorld.RequestSelect,
      org.example.helloWorld.Response> getCalculateMethod() {
    return getCalculateMethodHelper();
  }

  private static io.grpc.MethodDescriptor<org.example.helloWorld.RequestSelect,
      org.example.helloWorld.Response> getCalculateMethodHelper() {
    io.grpc.MethodDescriptor<org.example.helloWorld.RequestSelect, org.example.helloWorld.Response> getCalculateMethod;
    if ((getCalculateMethod = OperateSelectGrpc.getCalculateMethod) == null) {
      synchronized (OperateSelectGrpc.class) {
        if ((getCalculateMethod = OperateSelectGrpc.getCalculateMethod) == null) {
          OperateSelectGrpc.getCalculateMethod = getCalculateMethod = 
              io.grpc.MethodDescriptor.<org.example.helloWorld.RequestSelect, org.example.helloWorld.Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "OperateSelect", "Calculate"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.helloWorld.RequestSelect.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.helloWorld.Response.getDefaultInstance()))
                  .setSchemaDescriptor(new OperateSelectMethodDescriptorSupplier("Calculate"))
                  .build();
          }
        }
     }
     return getCalculateMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static OperateSelectStub newStub(io.grpc.Channel channel) {
    return new OperateSelectStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static OperateSelectBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new OperateSelectBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static OperateSelectFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new OperateSelectFutureStub(channel);
  }

  /**
   * <pre>
   *定义服务
   * </pre>
   */
  public static abstract class OperateSelectImplBase implements io.grpc.BindableService {

    /**
     */
    public void calculate(org.example.helloWorld.RequestSelect request,
        io.grpc.stub.StreamObserver<org.example.helloWorld.Response> responseObserver) {
      asyncUnimplementedUnaryCall(getCalculateMethodHelper(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCalculateMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                org.example.helloWorld.RequestSelect,
                org.example.helloWorld.Response>(
                  this, METHODID_CALCULATE)))
          .build();
    }
  }

  /**
   * <pre>
   *定义服务
   * </pre>
   */
  public static final class OperateSelectStub extends io.grpc.stub.AbstractStub<OperateSelectStub> {
    private OperateSelectStub(io.grpc.Channel channel) {
      super(channel);
    }

    private OperateSelectStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OperateSelectStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new OperateSelectStub(channel, callOptions);
    }

    /**
     */
    public void calculate(org.example.helloWorld.RequestSelect request,
        io.grpc.stub.StreamObserver<org.example.helloWorld.Response> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCalculateMethodHelper(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   *定义服务
   * </pre>
   */
  public static final class OperateSelectBlockingStub extends io.grpc.stub.AbstractStub<OperateSelectBlockingStub> {
    private OperateSelectBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private OperateSelectBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OperateSelectBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new OperateSelectBlockingStub(channel, callOptions);
    }

    /**
     */
    public org.example.helloWorld.Response calculate(org.example.helloWorld.RequestSelect request) {
      return blockingUnaryCall(
          getChannel(), getCalculateMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   *定义服务
   * </pre>
   */
  public static final class OperateSelectFutureStub extends io.grpc.stub.AbstractStub<OperateSelectFutureStub> {
    private OperateSelectFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private OperateSelectFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OperateSelectFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new OperateSelectFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.example.helloWorld.Response> calculate(
        org.example.helloWorld.RequestSelect request) {
      return futureUnaryCall(
          getChannel().newCall(getCalculateMethodHelper(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CALCULATE = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final OperateSelectImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(OperateSelectImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CALCULATE:
          serviceImpl.calculate((org.example.helloWorld.RequestSelect) request,
              (io.grpc.stub.StreamObserver<org.example.helloWorld.Response>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class OperateSelectBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    OperateSelectBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return org.example.helloWorld.HelloWorld.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("OperateSelect");
    }
  }

  private static final class OperateSelectFileDescriptorSupplier
      extends OperateSelectBaseDescriptorSupplier {
    OperateSelectFileDescriptorSupplier() {}
  }

  private static final class OperateSelectMethodDescriptorSupplier
      extends OperateSelectBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    OperateSelectMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (OperateSelectGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new OperateSelectFileDescriptorSupplier())
              .addMethod(getCalculateMethodHelper())
              .build();
        }
      }
    }
    return result;
  }
}
