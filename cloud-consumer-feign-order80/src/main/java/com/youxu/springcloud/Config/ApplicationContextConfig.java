package com.youxu.springcloud.Config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationContextConfig {

    //配置需要查看的日志级别
    @Bean
    public Logger.Level fullLevel(){
        return Logger.Level.FULL;
    }
}
