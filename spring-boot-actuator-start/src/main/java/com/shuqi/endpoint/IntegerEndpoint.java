package com.shuqi.endpoint;

import org.springframework.boot.actuate.endpoint.AbstractEndpoint;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicLong;

@Component
public class IntegerEndpoint extends AbstractEndpoint<Long> {

    private AtomicLong count = new AtomicLong();

    public IntegerEndpoint() {
        super("integer");
    }

    @Override
    public Long invoke() {
        return count.getAndIncrement();
    }
}
