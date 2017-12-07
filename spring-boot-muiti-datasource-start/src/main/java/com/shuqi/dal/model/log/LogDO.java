package com.shuqi.dal.model.log;

import lombok.Data;

import java.util.Date;

@Data
public class LogDO {

    /**
     * id
     */
    private Long id;

    /**
     * 业务ID
     */
    private String bizId;

    /**
     * 创建时间
     */
    private Date gmtCreated;

    /**
     * 修改时间
     */
    private Date gmtModified;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 业务域
     */
    private String domain;

    /**
     * 内容
     */
    private String content;
}
