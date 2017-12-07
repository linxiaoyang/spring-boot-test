package com.shuqi.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicLong;

@Component
public class ConsoleScheduler {

    private AtomicLong count = new AtomicLong();

    /**
     * 每秒都打印
     */
    @Scheduled(cron = "* * * * * ?")
    public void run() {
        System.out.println(count.getAndIncrement());
    }
}
