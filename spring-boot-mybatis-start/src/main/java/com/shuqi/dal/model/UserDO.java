package com.shuqi.dal.model;

import lombok.Data;

import java.util.Date;

@Data
public class UserDO {

    /**
     * id
     */
    private Long id;

    /**
     * 创建时间
     */
    private Date gmtCreated;

    /**
     * 修改时间
     */
    private Date gmtModified;

    /**
     * 姓名
     */
    private String name;

    /**
     * 状态
     */
    private Integer status;
}
