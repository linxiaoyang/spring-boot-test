package com.shuqi.controller;

import com.shuqi.service.LogService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class LogController {

    @Resource
    private LogService logService;

    @RequestMapping("/log")
    public String create() {
        Long id = logService.create(null);
        return "log的id为" + id;
    }

}
