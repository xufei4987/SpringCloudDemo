package com.youxu.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
@FeignClient(value = "CLOUD-PAYMENT-PROVIDER-HYSTRIX", fallback = PaymentFallbackService.class)
public interface PaymentFeignHystrixService {
    @GetMapping("/provider/payment/hystrix/success")
    public String paymentSuccess();

    @GetMapping("/provider/payment/hystrix/timeout")
    public String paymentTimeout();
}
