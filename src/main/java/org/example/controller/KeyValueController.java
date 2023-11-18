package org.example.controller;

import org.example.service.ServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/")
public class KeyValueController {

    /**
     * 服务对象
     */
    @Autowired
    private ServerService serverService;


    /**
     * register
     *
     */
    @GetMapping()
    public ResponseEntity<String> register(){
        return serverService.register();
    }

    /**
     * 测试数据接收情况
     */

    @PostMapping("test")
    public int test(@RequestBody String key){
        System.out.println("key = " + key);
        return 0;
    }

    /**
     * insertKeyValue
     */
    @PostMapping("")
    public  void insertKeyValue(@RequestBody Map<String, Object> map){
        serverService.insertKeyValue(map);
//        return
    }

    /**
     * selectValueByKey
     */
    @GetMapping(value = "{key}")
    public ResponseEntity<String> selectValueByKeyPath(@PathVariable("key") String key) {
        System.out.println("key = " + key);
       return serverService.selectValueByKey(key);
    }

//    /**
//     * modifyValueByKey
//     */
//    @PostMapping("modifyValueByKey")
//    public String modifyValueByKey(@RequestBody Map<String, Object> map) {
//        return server2Service.modifyValueByKey(map);
//    }
//
    /**
     *
     * deleteKeyValueByKey
     */
    @DeleteMapping(value = "{key}")
    public ResponseEntity<String> deleteKeyValueByKey(@PathVariable("key") String key){
        return serverService.deleteKeyValueByKey(key);
    }
}
