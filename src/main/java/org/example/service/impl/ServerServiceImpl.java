package org.example.service.impl;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.helloWorld.OperateType;
import org.example.service.ServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("serverService")
public class ServerServiceImpl implements ServerService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Value("${first_server}")
    private String firstServer;

    @Value("${first_port}")
    private String firstPort;

    @Value("${grpc_port}")
    private String gRPCPort;

    @Value("${next_grpc_port}")
    private String nextGRPCPort;

    @Value("${second_server}")
    private String secondServer;

    @Value("${second_port}")
    private String secondPort;

    /**
     *
     * register
     */
    @Override
    public ResponseEntity<String> register(){
        try{
            Map<String, String> map = new HashMap<>();
            map.put("serverName", firstServer);
            map.put("serverPort", firstPort);
            map.put("rpcPort", gRPCPort);
            if (redisTemplate.opsForValue().get("servers") == null ){
                List<Map<String, String>> list = new ArrayList<>();
                list.add(map);
                redisTemplate.opsForValue().set("servers", list);
            }else {
                List<Map<String, String>> list = (List<Map<String, String>>)redisTemplate.opsForValue().get("servers");
                list.add(map);
                redisTemplate.opsForValue().set("servers", list);
            }
            return ResponseEntity.ok().body("success");
        }catch (Exception e){
            System.out.println("e = " + e);
            return null;
        }
    }

    /**
     *
     * insertKeyValue
     */
    @Override
    public ResponseEntity<String> insertKeyValue(Map<String, Object> map){
        try{
            Map<String, Object> m = new HashMap<>();
            for (String key : map.keySet()) {
                m.put("key", key);
                m.put("value", map.get(key));
            }
            String msg = insertCheck(m);
            if( "not found".equals(msg)){
                List<String> list = new ArrayList<>();
                list.add(firstServer);
                redisTemplate.opsForValue().set("usedServers", list);

                RequestService service = new RequestService(secondServer, Integer.parseInt(nextGRPCPort));
                msg = service.operate(m.get("key").toString(), m.get("value").toString(), OperateType.InsertOrModify);
                try {
                    service.shutdown();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                if ("not found".equals(msg)){
                    if (redisTemplate.opsForValue().get(firstServer) == null){
                        Set<Object> set = new HashSet<>();
                        set.add(m.get("key"));
                        redisTemplate.opsForValue().set(firstServer, set);
                    }else {
                        HashSet<Object> set = (HashSet<Object>) redisTemplate.opsForValue().get(firstServer);
                        set.add(m.get("key"));
                        redisTemplate.opsForValue().set(firstServer, set);
                    }
                    msg = "insert";
                    redisTemplate.opsForValue().set(m.get("key"), m.get("value"));
                }
                redisTemplate.delete("usedServers");
                return ResponseEntity.status(500).body(msg + " " + firstServer + "\n");
            }else {
                redisTemplate.delete("usedServers");
                return ResponseEntity.status(200).body(msg + " " + firstServer + "\n");
            }
        }catch (Exception e){
            System.out.println("e = " + e);
            return null;
        }
    }
    /**
     *
     * insertCheck
     */
    @Override
    public String insertCheck(Map<String, Object> map){
        try{
            String msg = null;
            if (redisTemplate.opsForValue().get(firstServer) == null){
                msg = "not found";
            }else {
                HashSet<Object> set = (HashSet<Object>) redisTemplate.opsForValue().get(firstServer);
                if (set.contains(map.get("key"))){
                    redisTemplate.opsForValue().set(map.get("key"), map.get("value"));
                    msg = "modify";
                }else{
                    msg = "not found";
                }
            }
            return msg;
        }catch (Exception e){
            System.out.println("e = " + e);
            return null;
        }
    }


    /**
     * selectValueByKey
     */
    @Override
    public ResponseEntity<String> selectValueByKey(String key){
        try {
            String msg = selectCheck(key);
            if ("not found".equals(msg)){
                List<String> list = new ArrayList<>();
                list.add(firstServer);
                redisTemplate.opsForValue().set("usedServers", list);
                System.out.println("secondServer = " + secondServer);
                System.out.println("secondPort = " + secondPort);
                RequestService service = new RequestService(secondServer, Integer.parseInt(nextGRPCPort));
                msg = service.operate(key, "", OperateType.Select);
                try {
                    service.shutdown();
                } catch (InterruptedException e) {
                    System.out.println("1111111");
                    throw new RuntimeException(e);
                }
                if ("not found".equals(msg)){
                    redisTemplate.delete("usedServers");
                    return ResponseEntity.status(404).body("# 404, not found" + "\n");
                }
            }
            redisTemplate.delete("usedServers");
            return ResponseEntity.ok().body(msg + "\n");
        }catch (Exception e){
            System.out.println("e = " + e);
            return null;
        }
    }

    /**
     * selectCheck
     */
    @Override
    public String selectCheck(String key){
        System.out.println("key = " + key);
        try{
            String msg = null;
            if (redisTemplate.opsForValue().get(firstServer) == null){
                msg = "not found";
            }else {
                HashSet<Object> set = (HashSet<Object>) redisTemplate.opsForValue().get(firstServer);
                if (set.contains(key)){
                    Map<String, Object> map = new HashMap<>();
                    map.put(key, ((Object) redisTemplate.opsForValue().get(key)).toString());
                    ObjectMapper mapper = new ObjectMapper();
                    msg = mapper.writeValueAsString(map);
                }else{
                    msg = "not found";
                }
            }
            return msg;
        }catch (Exception e){
            System.out.println("e = " + e);
            return null;
        }
    }

//    /**
//     * modifyValueByKey
//     */
//    @Override
//    public String modifyValueByKey(Map<String, Object> map){
//        try{
//            ArrayList<Map<String, String>> serverList = (ArrayList<Map<String, String>>)map.get("serverList");
//            ArrayList<String> useList = (ArrayList<String>)map.get("useList");
//            String key = map.get("key").toString();
//            String value = map.get("value").toString();
//            HashSet<String> keys = (HashSet<String>)redisTemplate.opsForValue().get("server2");
//            if (keys != null && keys.contains(key)){
//                redisTemplate.opsForValue().set(key, value);
//                return "success";
//            }else{
//                int flag = 0;
//                useList.add("server2");
//                for (Map<String, String> server : serverList) {
//                    String serverName = server.get("serverName");
//                    if (!useList.contains(serverName)){
//                        flag = 1;
//                        int port = Integer.parseInt(server.get("serverPort"));
//                        return Ask.doPost("http://127.0.0.1:" + port + "/" + serverName + "/keyValue/modifyValueByKey", map);
//                    }
//                }
//                if (flag == 0) {
//                    return null;
//                }
//                return null;
//            }
//        }catch (Exception e){
//            System.out.println("e = " + e);
//            return null;
//        }
//    }

    /**
     *
     * deleteKeyValueByKey
     */
    @Override
    public ResponseEntity<String> deleteKeyValueByKey(String key){
        try{
            String msg = deleteCheck(key);
            if ("not found".equals(msg)){
                List<String> list = new ArrayList<>();
                list.add(firstServer);
                redisTemplate.opsForValue().set("usedServers", list);
                RequestService service = new RequestService(secondServer, Integer.parseInt(nextGRPCPort));
                msg = service.operate(key, "", OperateType.Delete);
                try {
                    service.shutdown();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                if ("not found".equals(msg)){
                    redisTemplate.delete("usedServers");
                    return ResponseEntity.status(200).body("0" + "\n");
                }
            }
            redisTemplate.delete("usedServers");
            return ResponseEntity.ok().body(msg + "\n");
        }catch (Exception e){
            System.out.println("e = " + e);
            return null;
        }
    }
    /**
     *
     * deleteCheck
     */
    @Override
    public String deleteCheck(String key){
        try{
            String msg = null;
            if (redisTemplate.opsForValue().get(firstServer) == null){
                msg = "not found";
            }else {
                HashSet<Object> set = (HashSet<Object>) redisTemplate.opsForValue().get(firstServer);
                if (set.contains(key)){
                    redisTemplate.delete(key);
                    set.remove(key);
                    redisTemplate.opsForValue().set(firstServer, set);
                    msg = "1";
                }else{
                    msg = "not found";
                }
            }
            return msg;
        }catch (Exception e){
            System.out.println("e = " + e);
            return null;
        }
    }

}
