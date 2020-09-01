package com.itmayiedu.api.service;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 *@author tom
 *Date  2020/5/2 0002 21:38
 *
 */
public interface IOrderService {
    //订单服务调用会员服务的接口
    @RequestMapping("/orderToMember")
    public String orderToMember(String name);
}
