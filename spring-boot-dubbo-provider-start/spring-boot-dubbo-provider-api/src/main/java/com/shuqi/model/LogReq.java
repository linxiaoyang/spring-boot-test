package com.shuqi.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class LogReq implements Serializable{

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



    public enum LogStatus {


        tryCreate(10,"预创建"),

        conform(20,"创建成功"),

        cancal(30,"取消")

        ;

        private Integer status;

        private String desc;

        LogStatus(Integer status, String desc) {
            this.status = status;
            this.desc = desc;
        }

        public Integer getStatus() {
            return status;
        }

        public void setStatus(Integer status) {
            this.status = status;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }
    }

}
