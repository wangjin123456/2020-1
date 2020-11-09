package com.taotao.loadbalancer;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 *@author tom
 *Date  2020/11/9 0009 14:18
 *
 */
public interface LoadBalancer {
    /**
     * 从注册中心获取单个的地址
     * @param serviceInstanceList
     * @return
     */

    ServiceInstance getSingleAddress(List<ServiceInstance> serviceInstanceList);
}
