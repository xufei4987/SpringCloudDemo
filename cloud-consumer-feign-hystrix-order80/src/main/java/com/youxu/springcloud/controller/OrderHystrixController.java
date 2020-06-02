package com.youxu.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.youxu.springcloud.service.PaymentFeignHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
//@DefaultProperties(defaultFallback="globalFallbackMethod")
public class OrderHystrixController {
    @Resource
    private PaymentFeignHystrixService paymentFeignHystrixService;

    @GetMapping("/payment/hystrix/success")
    public String paymentSuccess() {
        return paymentFeignHystrixService.paymentSuccess();
    }

    @GetMapping("/payment/hystrix/timeout")
//    @HystrixCommand(fallbackMethod = "paymentTimeoutFallback", commandProperties = {
//            //3s超时
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
//    })
    //使用全局的fallback
//    @HystrixCommand
    public String paymentTimeout() {
//        int i = 10 / 0;
        return paymentFeignHystrixService.paymentTimeout();
    }

    public String paymentTimeoutFallback() {
        return "当前线程：" + Thread.currentThread().getName() + "\t" + "consumer80:fallback调用成功";
    }

    public String globalFallbackMethod(){
        return "当前线程：" + Thread.currentThread().getName() + "\t" + "consumer80: global fallback调用成功";
    }
}
