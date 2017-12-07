package com.shuqi;

import com.shuqi.controller.HelloController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(ApplicationMain.class)
public class MyTest {

    @Resource
    private HelloController helloController;

    @Test
    public void test() {
        System.out.println(helloController.hello());
    }
}
