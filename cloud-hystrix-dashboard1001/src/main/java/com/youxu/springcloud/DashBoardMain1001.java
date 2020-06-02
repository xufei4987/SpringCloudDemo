package com.youxu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class DashBoardMain1001 {
    public static void main(String[] args) {
        SpringApplication.run(DashBoardMain1001.class,args);
    }
}
