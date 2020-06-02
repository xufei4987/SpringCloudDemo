package com.youxu.springcloud.service;

import com.youxu.springcloud.entities.CommonResult;
import com.youxu.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Component
@FeignClient(value = "CLOUD-PAYMENT-PROVIDER")
public interface PaymentFeignService {
    @PostMapping(value = "/provider/payment/create")
    CommonResult create(@RequestBody Payment payment);

    @GetMapping(value = "/provider/payment/get/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable(value = "id") Long id);

    @GetMapping("/provider/payment/timeout")
    String timeout();
}
