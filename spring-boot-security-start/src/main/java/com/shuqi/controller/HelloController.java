package com.shuqi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/index")
    public String index(){
        return "hello world index";
    }

    @RequestMapping("/index1")
    public String index1(){
        return "hello world index1";
    }
}
