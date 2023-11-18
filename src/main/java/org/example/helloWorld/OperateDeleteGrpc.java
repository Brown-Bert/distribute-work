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
public final class OperateDeleteGrpc {

  private OperateDeleteGrpc() {}

  public static final String SERVICE_NAME = "OperateDelete";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCalculateMethod()} instead. 
  public static final io.grpc.MethodDescriptor<org.example.helloWorld.RequestDelete,
      org.example.helloWorld.Response> METHOD_CALCULATE = getCalculateMethodHelper();

  private static volatile io.grpc.MethodDescriptor<org.example.helloWorld.RequestDelete,
      org.example.helloWorld.Response> getCalculateMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<org.example.helloWorld.RequestDelete,
      org.example.helloWorld.Response> getCalculateMethod() {
    return getCalculateMethodHelper();
  }

  private static io.grpc.MethodDescriptor<org.example.helloWorld.RequestDelete,
      org.example.helloWorld.Response> getCalculateMethodHelper() {
    io.grpc.MethodDescriptor<org.example.helloWorld.RequestDelete, org.example.helloWorld.Response> getCalculateMethod;
    if ((getCalculateMethod = OperateDeleteGrpc.getCalculateMethod) == null) {
      synchronized (OperateDeleteGrpc.class) {
        if ((getCalculateMethod = OperateDeleteGrpc.getCalculateMethod) == null) {
          OperateDeleteGrpc.getCalculateMethod = getCalculateMethod = 
              io.grpc.MethodDescriptor.<org.example.helloWorld.RequestDelete, org.example.helloWorld.Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "OperateDelete", "Calculate"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.helloWorld.RequestDelete.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.helloWorld.Response.getDefaultInstance()))
                  .setSchemaDescriptor(new OperateDeleteMethodDescriptorSupplier("Calculate"))
                  .build();
          }
        }
     }
     return getCalculateMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static OperateDeleteStub newStub(io.grpc.Channel channel) {
    return new OperateDeleteStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static OperateDeleteBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new OperateDeleteBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static OperateDeleteFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new OperateDeleteFutureStub(channel);
  }

  /**
   * <pre>
   *定义服务
   * </pre>
   */
  public static abstract class OperateDeleteImplBase implements io.grpc.BindableService {

    /**
     */
    public void calculate(org.example.helloWorld.RequestDelete request,
        io.grpc.stub.StreamObserver<org.example.helloWorld.Response> responseObserver) {
      asyncUnimplementedUnaryCall(getCalculateMethodHelper(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCalculateMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                org.example.helloWorld.RequestDelete,
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
  public static final class OperateDeleteStub extends io.grpc.stub.AbstractStub<OperateDeleteStub> {
    private OperateDeleteStub(io.grpc.Channel channel) {
      super(channel);
    }

    private OperateDeleteStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OperateDeleteStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new OperateDeleteStub(channel, callOptions);
    }

    /**
     */
    public void calculate(org.example.helloWorld.RequestDelete request,
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
  public static final class OperateDeleteBlockingStub extends io.grpc.stub.AbstractStub<OperateDeleteBlockingStub> {
    private OperateDeleteBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private OperateDeleteBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OperateDeleteBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new OperateDeleteBlockingStub(channel, callOptions);
    }

    /**
     */
    public org.example.helloWorld.Response calculate(org.example.helloWorld.RequestDelete request) {
      return blockingUnaryCall(
          getChannel(), getCalculateMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   *定义服务
   * </pre>
   */
  public static final class OperateDeleteFutureStub extends io.grpc.stub.AbstractStub<OperateDeleteFutureStub> {
    private OperateDeleteFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private OperateDeleteFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OperateDeleteFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new OperateDeleteFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.example.helloWorld.Response> calculate(
        org.example.helloWorld.RequestDelete request) {
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
    private final OperateDeleteImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(OperateDeleteImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CALCULATE:
          serviceImpl.calculate((org.example.helloWorld.RequestDelete) request,
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

  private static abstract class OperateDeleteBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    OperateDeleteBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return org.example.helloWorld.HelloWorld.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("OperateDelete");
    }
  }

  private static final class OperateDeleteFileDescriptorSupplier
      extends OperateDeleteBaseDescriptorSupplier {
    OperateDeleteFileDescriptorSupplier() {}
  }

  private static final class OperateDeleteMethodDescriptorSupplier
      extends OperateDeleteBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    OperateDeleteMethodDescriptorSupplier(String methodName) {
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
      synchronized (OperateDeleteGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new OperateDeleteFileDescriptorSupplier())
              .addMethod(getCalculateMethodHelper())
              .build();
        }
      }
    }
    return result;
  }
}
