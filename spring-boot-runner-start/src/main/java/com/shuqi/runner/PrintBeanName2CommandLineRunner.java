package com.shuqi.runner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;


/**
 * 打印Bean的名称
 */
@Component
@Slf4j
public class PrintBeanName2CommandLineRunner implements ApplicationRunner, ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        String[] beanNamesForType = this.applicationContext.getBeanNamesForType(Object.class);
        Stream.of(beanNamesForType).forEach(t -> log.info("bean name:{}", t));
    }
}
