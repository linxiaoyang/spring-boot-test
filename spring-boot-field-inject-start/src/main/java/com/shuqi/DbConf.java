package com.shuqi;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Component
@ConfigurationProperties(prefix="db")
@Data
public class DbConf {

    private String username;

    private String password;

    private List<String> ipList;

    private Map<String,String> map;

    private Child child;


    @Data
    public static class Child{

        private String address;

        private String postcode;

    }


}
