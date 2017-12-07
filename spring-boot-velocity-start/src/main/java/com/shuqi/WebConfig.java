package com.shuqi;


import org.springframework.boot.autoconfigure.velocity.VelocityProperties;
import org.springframework.boot.web.servlet.view.velocity.EmbeddedVelocityViewResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 *
 * @author linyang
 * @date 2017/5/9
 */
@Configuration
public class WebConfig {

    @Bean
    public EmbeddedVelocityViewResolver velocityViewResolver(VelocityProperties properties) {
        EmbeddedVelocityViewResolver resolver = new EmbeddedVelocityViewResolver();
        properties.applyToViewResolver(resolver);
        resolver.setRedirectHttp10Compatible(false);
        return resolver;
    }

}
