package com.itmayido.springcloud_2_eureka_order.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 *@author tom
 *Date  2020/4/20 0020 15:42
 *
 */
@RestController
public class ExtRibbonController {
    //可以获取注册中心的服务列表
    @Autowired
    private DiscoveryClient discoveryClient;
    //纯手写Ribbon本地负载均衡效果
    @Autowired
    private RestTemplate restTemplate;
    //接口请求总数
    private int reqCount = 1;

    @RequestMapping("/ribbonMember")
    public String ribbonMember() {
        //1, 获取对应服务器远程调用地址
        //2, 在使用rest 方式发送请求
        String instancesUrl = getInstances() + "/getMember";
        System.out.println("instancesUrl:" + instancesUrl);
        String result = restTemplate.getForObject(instancesUrl, String.class);

        return result;
    }

    private String getInstances() {
        List<ServiceInstance> instances = discoveryClient.getInstances("APP-ITMAYIDU-MEMBER");
        if (instances == null || instances.size() < 0) {
            return null;
        }
        //获取服务器集群个数
        int instancesize = instances.size();
        int serviceindex = reqCount % instancesize;
        reqCount++;
       String result=instances.get(serviceindex).getInstanceId().toString();
           String[] s=result.split(":");

         result="http://"+s[1];
        return result;
    }
}