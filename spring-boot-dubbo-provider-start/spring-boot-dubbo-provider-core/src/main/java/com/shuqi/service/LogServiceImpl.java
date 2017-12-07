package com.shuqi.service;


import com.shuqi.model.LogReq;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class LogServiceImpl implements LogService {

    private AtomicLong count = new AtomicLong();

    @Override
    public Long create(LogReq logReq) {
        return count.getAndIncrement();
    }


}
