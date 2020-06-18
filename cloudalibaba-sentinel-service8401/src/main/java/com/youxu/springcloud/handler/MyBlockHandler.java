package com.youxu.springcloud.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.youxu.springcloud.entities.CommonResult;

public class MyBlockHandler {
    public CommonResult handleException(BlockException exception)
    {
        return new CommonResult(444,exception.getClass().getCanonicalName()+"\t 服务不可用");
    }
}
