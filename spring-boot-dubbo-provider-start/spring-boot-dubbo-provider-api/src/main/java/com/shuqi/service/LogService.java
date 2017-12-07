package com.shuqi.service;


import com.shuqi.model.LogReq;

public interface LogService {

    /**
     * 创建日志
     * @param logReq
     */
    Long create(LogReq logReq);

}
