package com.shuqi.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api
public class HelloController {

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    @ApiOperation(value = "hello", notes = "hello")
    public String hello(@ApiParam("姓名") @RequestParam String name,@ApiParam("年龄") @RequestParam Integer age) {
        return "我的名字叫" + name + ",年龄是" + age;
    }
}
