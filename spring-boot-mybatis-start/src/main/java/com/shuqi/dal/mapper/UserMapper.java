package com.shuqi.dal.mapper;


import com.shuqi.dal.model.UserDO;

public interface UserMapper {

    void create(UserDO userDO);

    void modify(UserDO userDO);

    UserDO findByName(String name);
}
