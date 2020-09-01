package com.taotao.zuoye.daili.service;

/**
 *@author tom
 *Date  2020/7/10 0010 18:05
 *
 */
public class Test01 {
    public static void main(String[] args) {
        OrderService orderService = new OrderServiceProxy(new OrderServiceImpl());
        orderService.addOrder("11", "22");


    }


}
