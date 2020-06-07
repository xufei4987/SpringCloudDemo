package com.youxu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope //配置动态刷新范围，需要添加actuator依赖，并在配置文件中添加暴露actuator/refresh路径，并调用该url进行手动刷新
public class ConfigController {
    @Value("${youxu.config.name}")
    private String configName;

    @GetMapping("configInfo")
    public String getConfigInfo(){
        return configName;
    }
}
