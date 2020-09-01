package com.taotao.bkproxy.service;

import com.taotao.bkproxy.jdk.MYInvocationHandler;
import com.taotao.bkproxy.service.impl.OrderServiceImpl;

/**
 *@author tom
 *Date  2020/5/18 0018 7:38
 *
 */
public class Test003 {
    public static void main(String[] args) {
        MYInvocationHandler myInvocationHandler=new MYInvocationHandler(new OrderServiceImpl());
        OrderService proxy=myInvocationHandler.getProxy();
        proxy.addOrder("33","333");
    }
}
