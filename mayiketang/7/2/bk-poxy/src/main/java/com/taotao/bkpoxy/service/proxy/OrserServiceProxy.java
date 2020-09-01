package com.taotao.bkpoxy.service.proxy;

import com.taotao.bkpoxy.service.OrderService;
import com.taotao.bkpoxy.service.impl.OrderServiceImpl;

/**
 *@author tom
 *Date  2020/7/5 0005 20:28
 *
 */
public class OrserServiceProxy   extends OrderServiceImpl {
/*
    private OrderServiceImpl orderService;

    public OrserServiceProxy(OrderServiceImpl orderService) {
        this.orderService = orderService;
    }*/

    @Override
    public String addOrder(String orderId, String orderName) {
        System.out.println("采用代理日志模式打印日志： orderId:"+orderId+",ordername:"+orderName);
        return  super.addOrder(orderId,orderName);
    }
}
