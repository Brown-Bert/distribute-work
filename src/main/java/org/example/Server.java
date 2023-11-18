package org.example;



import org.example.service.impl.Init;
import org.example.utils.Ask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.core.env.Environment;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication()
//@MapperScan("cn.edu.sicnu.dao")
//@MapperScan("cn.edu.sicnu.mapper")
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class Server {



    public static void main(String[] args) {
        try{
            SpringApplication.run(Server.class,args);
            System.out.println("success");
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("e = " + e);
        }
    }

}