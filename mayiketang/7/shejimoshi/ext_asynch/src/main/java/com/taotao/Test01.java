package com.taotao;

import com.taotao.jdk.MayiktInvocationHandler;
import com.taotao.service.OrderService;
import com.taotao.service.impl.OrderServiceImpl;

/**
 *@author tom
 *Date  2020/5/21 0021 18:37
 *
 */
public class Test01 {
    public static void main(String[] args) {
        OrderServiceImpl orderServiceImpl=new OrderServiceImpl();


        MayiktInvocationHandler mayiktInvocationHandler=new MayiktInvocationHandler(orderServiceImpl);
        //使用javajdk 动态代理生成对象
        OrderService orderService=mayiktInvocationHandler.getProxy();
        orderServiceImpl.setOrderServiceProxy(orderService);
        orderService.addorder();
    }
}
