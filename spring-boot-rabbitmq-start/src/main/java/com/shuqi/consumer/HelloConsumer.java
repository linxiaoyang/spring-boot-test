package com.shuqi.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "hello")
@Slf4j
public class HelloConsumer {

    @RabbitHandler
    public void process(String hello) {
        log.info("接收到的消息：message:{}",hello);
    }
}
