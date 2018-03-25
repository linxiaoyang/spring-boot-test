package com.shuqi.endpoint;

import org.springframework.boot.actuate.endpoint.AbstractEndpoint;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicLong;

@Component
public class LongEndpoint extends AbstractEndpoint<Long> {

    private AtomicLong count = new AtomicLong();

    public LongEndpoint() {
        super("long");
    }

    @Override
    public Long invoke() {
        return count.getAndIncrement();
    }
}
