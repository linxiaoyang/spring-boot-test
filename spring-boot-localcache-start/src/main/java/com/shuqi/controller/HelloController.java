package com.shuqi.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HelloController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @Cacheable(cacheNames = "ONE_DAY", key = "'hello name:'+#name+',age:'+#age", unless = "#result==null")
    public String hello(@RequestParam String name, @RequestParam Integer age) {
        log.info("HelloController hello,name:{},age:{}", name, age);
        return "我的名字叫" + name + ",年龄是" + age;
    }
}
