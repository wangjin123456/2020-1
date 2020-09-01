package com.itmayido.springcloud_2_eureka_order.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author tom
 * Date  2020/4/17 0017 10:51
 */
@RestController
public class OrderController {
    @Autowired
    private RestTemplate restTemplate;

    /**
     * 订单服务调用会员服务
     * @return
     */
    @RequestMapping("/getOrder")
    public  String getOrder(){
        String url="http://APP-ITMAYIDU-MEMBER/getMember";
        String result=restTemplate.getForObject(url,String.class);
        System.out.println(result);
        return  result;
    }
}
