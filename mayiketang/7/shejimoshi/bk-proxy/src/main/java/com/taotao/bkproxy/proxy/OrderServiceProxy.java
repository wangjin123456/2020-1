package com.taotao.bkproxy.proxy;

import com.taotao.bkproxy.service.OrderService;
import com.taotao.bkproxy.service.impl.OrderServiceImpl;

/**
 *@author tom
 *Date  2020/5/17 0017 23:32
 *目标代理类
 */
//public class OrderServiceProxy implements OrderService {
public class  OrderServiceProxy extends  OrderServiceImpl{
  /*  private OrderServiceImpl orderService;

    public OrderServiceProxy(OrderServiceImpl orderService) {
        this.orderService = orderService;
    }*/



    @Override
    public String addOrder(String orderId, String orderName) {
        System.out.println("静态代理实现接口方式开始");
       // String result = orderService.addOrder(orderId, orderName);
        String result = super.addOrder(orderId, orderName);
        System.out.println("静态代理实现接口方式结束；");
        return result;
    }
}
