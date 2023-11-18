package org.example.service;

import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface ServerService {


    /**
     *
     * register
     */
    ResponseEntity<String> register();

    /**
     *
     * insertKeyValue
     */
    ResponseEntity<String> insertKeyValue(Map<String, Object> map);

    /**
     *
     * insertCheck
     */
    String insertCheck(Map<String, Object> map);

    /**
     * selectValueByKey
     */
    ResponseEntity<String> selectValueByKey(String key);
    /**
     * selectCheck
     */
    String selectCheck(String key);


//    /**
//     * modifyValueByKey
//     */
//    String modifyValueByKey(Map<String, Object> map);

    /**
     *
     * deleteKeyValueByKey
     */
    ResponseEntity<String> deleteKeyValueByKey(String key);

    /**
     *
     * deleteCheck
     */
    String deleteCheck(String key);

}
