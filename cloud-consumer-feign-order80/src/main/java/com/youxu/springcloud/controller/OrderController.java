package com.youxu.springcloud.controller;

import com.youxu.springcloud.entities.CommonResult;
import com.youxu.springcloud.entities.Payment;
import com.youxu.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController {
    @Resource
    private PaymentFeignService paymentFeignService;

    @PostMapping("/payment/create")
    public CommonResult<Payment> create(@RequestBody Payment payment) {
        return paymentFeignService.create(payment);
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable Long id) {
        return paymentFeignService.getPaymentById(id);
    }

    @GetMapping("/payment/timeout")
    public String timeout() {
        return paymentFeignService.timeout();
    }

}
