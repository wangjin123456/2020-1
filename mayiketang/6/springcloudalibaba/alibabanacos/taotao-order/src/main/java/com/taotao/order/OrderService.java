package com.taotao.order;

import com.taotao.loadbalancer.RotationLoadBalancer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

/**
 *@author tom
 *Date  2020/11/9 0009 13:30
 *
 */
@RestController
public class OrderService {
   @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private DiscoveryClient discoveryClient;
   @Autowired
    private RotationLoadBalancer loadBalancer;

    /**
     * 订单服务调用会员服务
     * @return
     */
    @RequestMapping("/orderToMember")
    public Object orderToMember() {
//1 根据服务名称从注册中心获取集群地址
        List<ServiceInstance> instanceList = discoveryClient.getInstances("taotao-member");
        //2 列表任意选择一个 实现本地的rpc调用rest
/*         ServiceInstance serviceInstance=instanceList.get(0);
              URI url=serviceInstance.getUri();*/
        ServiceInstance serviceInstance=loadBalancer.getSingleAddress(instanceList);
        URI url=serviceInstance.getUri();
         String result=restTemplate.getForObject(url+"/getUser?userId=3",String.class);


        return "调用订单返回结果"+result;
    }
}
