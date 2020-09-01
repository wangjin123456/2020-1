package com.taotao.bkproxy.service;

import com.taotao.bkproxy.proxy.OrderServiceProxy;
import com.taotao.bkproxy.service.impl.OrderServiceImpl;

/**
 *@author tom
 *Date  2020/5/17 0017 23:27
 *
 */
public class Test001 {
    public static void main(String[] args) {
       // OrderServiceImpl orderService = new OrderServiceImpl();
        //orderService.addOrder("33","33");
       // OrderServiceProxy orderServiceProxy=new OrderServiceProxy(new OrderServiceImpl());
        OrderServiceProxy orderServiceProxy=new OrderServiceProxy(  );
      orderServiceProxy.addOrder("22","222");
    }
}
