package com.shuqi;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Component
@ConfigurationProperties(prefix="db")
@Data
public class DbConf {

    private String username;

    private String password;


}
