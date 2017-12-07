package com.shuqi.dal.mapper.user;


import com.shuqi.dal.model.user.UserDO;

public interface UserMapper {

    void create(UserDO userDO);

    void modify(UserDO userDO);

    UserDO findByName(String name);
}
