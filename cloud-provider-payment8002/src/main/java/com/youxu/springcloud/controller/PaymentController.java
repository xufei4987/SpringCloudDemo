package com.youxu.springcloud.controller;

import com.youxu.springcloud.entities.CommonResult;
import com.youxu.springcloud.entities.Payment;
import com.youxu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Slf4j
@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Value("${server.port}")
    private String port;

    @Resource
    private PaymentService paymentService;

    @PostMapping(value = "/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("插入结果=======>" + result);
        return result > 0 ? new CommonResult(200,"数据插入成功,port=" + port,result) : new CommonResult(444,"数据插入失败,port=" + port,result);
    }

    @GetMapping(value = "/get/{id}")
    public CommonResult getPaymentById(@PathVariable Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("查询结果=======>" + payment);
        return payment != null ? new CommonResult(200,"数据查询成功,port=" + port,payment) : new CommonResult(443,"数据查询失败,port=" + port,null);
    }

    @GetMapping("/lb")
    public String getPaymentLb(){
        return this.port;
    }

    @GetMapping("/timeout")
    public String timeout(){
        try {
            TimeUnit.SECONDS.sleep(3);
        }catch (Exception e){
            e.printStackTrace();
        }
        return port;
    }
}
