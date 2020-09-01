package com.taotao.zuoye.jdk.service;

import com.taotao.zuoye.daili.service.OrderServiceImpl;

/**
 *@author tom
 *Date  2020/7/10 0010 18:43
 *
 */
public class Test2 {
    public static void main(String[] args) {
        //System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        JdkInvocationHandler jdkInvocationHandler = new JdkInvocationHandler(new OrderServiceImpl());
        OrderServiceImpl orderService = jdkInvocationHandler.getProxy();
        orderService.addOrder("11", "33");


    }
}
