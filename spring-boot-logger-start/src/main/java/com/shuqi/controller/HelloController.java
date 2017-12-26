package com.shuqi.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class HelloController {

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello(){
        log.debug("debug");
        log.info("info");
        log.warn("warn");
        log.error("error");
        return "hello world";
    }
}
