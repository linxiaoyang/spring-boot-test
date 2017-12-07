package com.shuqi;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
@Slf4j
public class ApplicationMain implements InitializingBean{

    @Resource
    private DbConf dbConf;

    public static void main(String[] args) {
        SpringApplication.run(ApplicationMain.class, args);
        System.out.println(new SimpleDateFormat("[yyyy-MM-dd HH:mm:ss]").format(new Date()) + " server started!");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("dbConf:{}",dbConf);
    }
}
