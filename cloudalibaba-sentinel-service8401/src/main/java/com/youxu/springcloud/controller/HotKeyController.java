package com.youxu.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HotKeyController {
    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey", blockHandler = "myBlockHandler")
    public String testHotKey(@RequestParam(value = "p1", required = false) String p1,
                             @RequestParam(value = "p2", required = false) String p2) {
        return "-------testHotKey-------";
    }

    public String myBlockHandler(String p1, String p2, BlockException blockException) {
        return "-------sentinelBlockHandler-------";
    }
}
