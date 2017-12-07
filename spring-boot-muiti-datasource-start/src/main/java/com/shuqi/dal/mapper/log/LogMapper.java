package com.shuqi.dal.mapper.log;


import com.shuqi.dal.model.log.LogDO;

public interface LogMapper {

    void create(LogDO logDO);

    int modify(LogDO logDO);

    int modifyByBizId(LogDO logDO);

     int deleteByBizId(String bizId) ;
}
