package com.shuqi;

import com.shuqi.listener.TestListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class ApplicationMain {

    public static void main(String[] args) {
        SpringApplication springApplication=new SpringApplication(ApplicationMain.class);
        springApplication.addListeners(new TestListener());
        springApplication.run(args);

        System.out.println(new SimpleDateFormat("[yyyy-MM-dd HH:mm:ss]").format(new Date()) + " server started!");
    }
}
