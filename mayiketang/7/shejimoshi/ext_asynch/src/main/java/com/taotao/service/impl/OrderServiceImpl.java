package com.taotao.service.impl;

import com.taotao.ext.ExtAsync;
import com.taotao.service.MemberServiceMessage;
import com.taotao.service.OrderService;

/**
 *@author tom
 *Date  2020/5/21 0021 20:20
 *
 */
public class OrderServiceImpl implements OrderService {
    private OrderService orderServiceProx;


    @Override
    public String addorder() {
        MemberServiceMessage.addUserLog();
       // System.out.println(Thread.currentThread().getName() + ">>>流程1");
    //    orderServiceProx.addOrderLog();
     //   System.out.println(Thread.currentThread().getName() + "》》》流程3");
        return null;
    }

    @ExtAsync
    @Override
    public void addOrderLog() {
        System.out.println(Thread.currentThread().getName() + ">>>流程2");

    }


    public void setOrderServiceProxy(OrderService orderService) {
        this.orderServiceProx = orderService;
    }
}
