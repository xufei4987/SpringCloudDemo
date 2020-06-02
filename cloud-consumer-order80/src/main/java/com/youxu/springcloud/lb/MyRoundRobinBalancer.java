package com.youxu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class MyRoundRobinBalancer implements LoadBalancer {

    private AtomicInteger count = new AtomicInteger(0);

    @Override
    public ServiceInstance getServiceInstance(List<ServiceInstance> serviceInstances) {
        int size = serviceInstances.size();
        int index = this.getNext() % size;
        return serviceInstances.get(index);
    }

    private final int getNext(){
        int current,next;
        do{
            current = count.get();
            next = current >= Integer.MAX_VALUE ? 0 : current + 1;
        }while (!count.compareAndSet(current,next));
        System.out.println("******当前访问次数为：" + count.get());
        return next;
    }
}
