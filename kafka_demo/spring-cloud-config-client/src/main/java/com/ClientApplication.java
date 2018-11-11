package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ClientApplication {
    public static void main(String[] args){
        SpringApplication.run(ClientApplication.class,args);
        System.out.println("配置服务客户端启动");
    }
}
