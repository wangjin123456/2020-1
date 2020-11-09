package com.taotao.loadbalancer;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *@author tom
 *Date  2020/11/9 0009 14:21
 *
 */
@Component
public class RotationLoadBalancer  implements  LoadBalancer{

    private AtomicInteger atomicInteger=new AtomicInteger(0);
//从0开始计数
    @Override
    public ServiceInstance getSingleAddress(List<ServiceInstance> serviceInstanceList) {
      int index=atomicInteger.incrementAndGet()%serviceInstanceList.size();


        return serviceInstanceList.get(index);
    }
}
