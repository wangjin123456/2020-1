package com.taotao.order.service.api.impl;

import com.taotao.order.service.api.impl.openfeign.MemberServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *@author tom
 *Date  2020/11/10 0010 11:45
 *
 */
@RestController
public class OrderService {
@Autowired
private MemberServiceFeign memberServiceFeign;

    /**
     * 基于我们的feign 客户端形式实现rpc远程调用
     * @return
     */
    @GetMapping("/orderFeignToMember")
    public  String orderFeignToMember(){
String result=memberServiceFeign.getUser(1);
        return  "我是订单服务调用会员服务接口。返回结果"+result;
    }
}
