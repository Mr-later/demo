package com.wsw.spring_demo_1;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @RequestMapping("/hello")
    public String hello(){
        System.out.println("wangshiwei is a good man");
        return  "wangshiwei is a good man";
    }
}
