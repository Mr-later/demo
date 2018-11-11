package com.wsw.springmybatisdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wsw.springmybatisdemo.dao")
public class SpringMybatisDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringMybatisDemoApplication.class, args);
    }
}
