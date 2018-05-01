package com.shuqi;

import com.shuqi.anno.MyConditionalOnProperty;
import com.shuqi.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author linyang on 18/5/1.
 */
@Slf4j
@Configuration
public class MyConfig {

    @Bean
    @MyConditionalOnProperty(value = "env",havingValues = {"dev","test"})
    public Person person(){
        log.info("创建Bean");
        return new Person();
    }
}
