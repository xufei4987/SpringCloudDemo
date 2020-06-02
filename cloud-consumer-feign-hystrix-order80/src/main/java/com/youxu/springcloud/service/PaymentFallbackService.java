package com.youxu.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * 服务降级处理类,和feign配合使用，需要实现feign封装的接口PaymentFeignHystrixService
 */
@Component
public class PaymentFallbackService implements PaymentFeignHystrixService {
    @Override
    public String paymentSuccess() {
        return "paymentSuccess fallback";
    }

    @Override
    public String paymentTimeout() {
        return "paymentTimeout fallback";
    }
}
