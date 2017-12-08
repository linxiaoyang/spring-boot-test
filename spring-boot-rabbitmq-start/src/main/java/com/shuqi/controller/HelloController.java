package com.shuqi.controller;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @RequestMapping("/hello")
    public String hello(@RequestParam String name){
        rabbitTemplate.convertAndSend("hello","hello "+name);
        return "消息发送成功";
    }

}
