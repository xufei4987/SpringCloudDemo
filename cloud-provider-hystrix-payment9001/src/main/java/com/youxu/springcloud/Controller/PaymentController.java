package com.youxu.springcloud.Controller;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    @GetMapping("/hystrix/success")
    public String paymentSuccess(){
        return "当前线程：" + Thread.currentThread().getName() + "\t" + "paymentSuccess调用成功";
    }

    /**
     * 相关配置详见 HystrixCommandProperties
     * 超时或运行时异常都会服务降级
     * @return
     */
    @GetMapping("/hystrix/timeout")
    @HystrixCommand(fallbackMethod = "paymentTimeoutFallback", commandProperties = {
            //3s超时
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String paymentTimeout(){
//        int i = 10 / 0;
        try {
            TimeUnit.MILLISECONDS.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "当前线程：" + Thread.currentThread().getName() + "\t" + "timeout调用成功";
    }

    public String paymentTimeoutFallback(){
        return "当前线程：" + Thread.currentThread().getName() + "\t" + "fallback调用成功";
    }

    /**
     * ===============服务熔断================
     */
    @GetMapping("/hystrix/break/{id}")
    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerFallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),//开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),//请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),//失败概率达到多少后跳闸

    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        if(id < 0){
            throw new RuntimeException("id不能为负数");
        }
        return Thread.currentThread().getName() + "\t调用成功，流水号为：" + IdUtil.simpleUUID();
    }

    public String paymentCircuitBreakerFallback(@PathVariable("id") Integer id){
        return "id不能为负数,请稍后重试！";
    }
}
