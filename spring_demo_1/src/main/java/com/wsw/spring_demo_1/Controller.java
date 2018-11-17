package com.wsw.spring_demo_1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    private static final Logger log = LoggerFactory.getLogger(Controller.class);
    private   final  MyProperties1 myProperties;
    private   final  MyProperties2 myProperties2;
    public Controller( MyProperties1 myProperties,MyProperties2 myProperties2){
        this.myProperties=myProperties;
        this.myProperties2=myProperties2;
    }
    @RequestMapping("/hello")
    public String hello(){
   System.out.println("进入到hello方法");
        return  "myProperties:"+myProperties+"  myProperties2="+myProperties2;
    }


}
