package com.taotao.bkpoxy.service;

import com.taotao.bkpoxy.service.impl.OrderServiceImpl;
import com.taotao.bkpoxy.service.proxy.jdk.JdkInvocationHandler;

/**
 *@author tom
 *Date  2020/7/5 0005 21:00
 *
 */
public class Test002 {
    public static void main(String[] args) {
        JdkInvocationHandler jdkInvocationHandler=new JdkInvocationHandler(new OrderServiceImpl());
        //创建代理类
        //查看jdk动态生成的代理类代码
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");
        // 获取代理类对象
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        OrderService proxy=jdkInvocationHandler.getProxy();
        proxy.addOrder("1","me");

    }
}
