package org.example.service.impl;

import org.example.utils.Ask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
@Component
public class Init implements ApplicationRunner {

    @Value("${first_server}")
    private String firstServer;

    @Value("${first_port}")
    private String firstPort;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // 执行您需要自动执行的操作
        System.out.println("firstServer = " + firstServer);
        System.out.println("firstPort = " + firstPort);
        Ask.doGet("http://"+ firstServer +":" + firstPort);
        System.out.println("Executing application runner");
    }

}
