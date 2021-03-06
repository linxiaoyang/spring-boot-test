package com.shuqi;

import com.alibaba.dubbo.config.*;
import com.alibaba.dubbo.config.spring.ServiceBean;
import com.shuqi.service.LogService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DubboConfig {

    @Bean
    public ApplicationConfig application() {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("log");
        return applicationConfig;
    }

    @Bean
    public RegistryConfig registry() {
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress("127.0.0.1:2181");
        registryConfig.setProtocol("zookeeper");
        return registryConfig;
    }

    @Bean
    public ProtocolConfig protocol() {
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setPort(20880);
        protocolConfig.setThreads(100);
        return protocolConfig;
    }

//    @Bean
//    public MonitorConfig monitor() {
//        MonitorConfig monitorConfig = new MonitorConfig();
//        monitorConfig.setProtocol("registry");
//        return monitorConfig;
//    }


    @Bean
    public ProviderConfig provider() {
        ProviderConfig providerConfig = new ProviderConfig();
        providerConfig.setTimeout(30000);
        providerConfig.setRetries(0);
        providerConfig.setVersion("LATEST");
        providerConfig.setProxy("javassist");
        return providerConfig;
    }


    @Bean
    public ConsumerConfig consumer() {
        ConsumerConfig rc = new ConsumerConfig();
        rc.setTimeout(30000);
        rc.setRetries(0);
        rc.setVersion("LATEST");
        rc.setCheck(false);
        return rc;
    }



    /***********************暴露服务******************************/

    @Bean
    public ServiceBean logServiceServiceBean(LogService logService){
        ServiceBean<LogService> serviceBean=new ServiceBean<>();
        serviceBean.setInterface(LogService.class);
        serviceBean.setRef(logService);
        return serviceBean;
    }




}
