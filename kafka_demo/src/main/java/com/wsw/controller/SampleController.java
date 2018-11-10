package com.wsw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
//@RequestMapping("/sampleController")
public class SampleController {
    @Autowired
    private KafkaTemplate<String, String>  template;

    @GetMapping("/send")
    String send(HttpServletRequest request) {
        System.out.println("send fanfa ");
        template.send( request.getParameter("topic"),  request.getParameter("key"),  request.getParameter("data"));
        return "success";
    }
}
