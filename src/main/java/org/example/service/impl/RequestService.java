package org.example.service.impl;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.example.helloWorld.*;

import java.util.concurrent.TimeUnit;

public class RequestService {

    private final ManagedChannel channel;
    private final OperateInsertOrModifyGrpc.OperateInsertOrModifyBlockingStub blockingStub;
    private final OperateSelectGrpc.OperateSelectBlockingStub blockingStubSelect;
    private final OperateDeleteGrpc.OperateDeleteBlockingStub blockingStubDelete;

    private RequestService(ManagedChannel channel) {
        this.channel = channel;
        this.blockingStub = OperateInsertOrModifyGrpc.newBlockingStub(channel);
        this.blockingStubSelect = OperateSelectGrpc.newBlockingStub(channel);
        this.blockingStubDelete = OperateDeleteGrpc.newBlockingStub(channel);
    }

    public RequestService(String host, int port) {
        this(ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .build());
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    public String operate(String key, String value, OperateType operateType) {
        if (operateType == OperateType.InsertOrModify) {
            RequestInsertOrModify request = RequestInsertOrModify.newBuilder().setKey(key).setValue(value).setOpType(operateType).build();
            Response response = this.blockingStub.calculate(request);
            return response.getResult();
        } else if (operateType == OperateType.Select) {
            System.out.println("123");
            RequestSelect request = RequestSelect.newBuilder().setKey(key).setOpType(operateType).build();
            System.out.println("456");
            Response response = this.blockingStubSelect.calculate(request);
            System.out.println("789");
            return response.getResult();
        }else{
            RequestDelete request = RequestDelete.newBuilder().setKey(key).setOpType(operateType).build();
            Response response = this.blockingStubDelete.calculate(request);
            return response.getResult();
        }
    }

//    public static void main(String[] args) {
//        try {
//            CalculateService service = new CalculateService("localhost", 6565);
//            System.out.println(service.operate(100, 0, OperateType.Division));
//            service.shutdown();
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//    }
}
