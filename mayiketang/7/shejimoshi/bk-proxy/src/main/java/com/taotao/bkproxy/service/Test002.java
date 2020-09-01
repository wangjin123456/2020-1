package com.taotao.bkproxy.service;

import com.taotao.bkproxy.jdk.JdkInvocationHandler;
import com.taotao.bkproxy.service.impl.OrderServiceImpl;

/**
 *@author tom
 *Date  2020/5/18 0018 0:10
 *
 */
public class Test002 {
    public static void main(String[] args) {
        JdkInvocationHandler jdkInvocationHandler=new JdkInvocationHandler(new OrderServiceImpl());
         //获取代理类对象
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        OrderService proxy=jdkInvocationHandler.getProxy();
        proxy.addOrder("33","33");
    }
}
