package com.shuqi.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${env}")
    private String env;

    @RequestMapping("/hello")
    public String hello() {
        return "hello " + env;
    }

}
