package org.example.service.impl;

import io.grpc.stub.StreamObserver;
import org.example.helloWorld.OperateInsertOrModifyGrpc;
import org.example.helloWorld.OperateType;
import org.example.helloWorld.RequestInsertOrModify;
import org.example.helloWorld.Response;
import org.example.service.ServerService;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@GRpcService
public class ResponseInsertService extends OperateInsertOrModifyGrpc.OperateInsertOrModifyImplBase {

    @Autowired
    private ServerService serverService;

    @Autowired
    private RedisTemplate redisTemplate;

    @Value("${first_server}")
    private String firstServer;

    @Override
    public void calculate(RequestInsertOrModify request, StreamObserver<Response> responseObserver) {
        System.out.println("request.getKey() = " + request.getKey());
        System.out.println("request.getValue() = " + request.getOpType());
        Map<String, Object> map = new HashMap<>();
        map.put("key", request.getKey());
        map.put("value", request.getValue());
        String res = null;
        res = serverService.insertCheck(map);
        if ("not found".equals(res)){
            List<String> usedServers = (List<String>)redisTemplate.opsForValue().get("usedServers");
            List<Map<String, String>> servers = (List<Map<String, String>>)redisTemplate.opsForValue().get("servers");
            usedServers.add(firstServer);
            redisTemplate.opsForValue().set("usedServers", usedServers);
            int flag = 1;
            for (Map<String, String> server : servers) {
                String name = server.get("serverName");
                if (!usedServers.contains(name)){
//                    RequestService service = new RequestService("localhost", Integer.parseInt(server.get("rpcPort")));
                    RequestService service = new RequestService(name, Integer.parseInt(server.get("rpcPort")));
                    res = service.operate(map.get("key").toString(), map.get("value").toString(), OperateType.InsertOrModify);
                    try {
                        service.shutdown();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    flag = 0;
                    break;
                }
            }
            if (flag == 1)res = "not found";
        }
        Response response=Response.newBuilder().setResult(res).build();
//        System.out.println(response);
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
