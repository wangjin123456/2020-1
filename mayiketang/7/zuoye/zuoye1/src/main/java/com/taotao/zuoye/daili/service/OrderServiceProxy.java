package com.taotao.zuoye.daili.service;

/**
 *@author tom
 *Date  2020/7/10 0010 18:00
 *
 */
public class OrderServiceProxy extends OrderServiceImpl {
    private OrderService orderService;

    public OrderServiceProxy(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public String addOrder(String userName, String userPwd) {
        System.out.println("使用静态代理类打印日志开始：userName:" + userName + "," + userPwd);


        String result = orderService.addOrder(userName, userPwd);
        System.out.println("使用静态代理打印日志结束");
        return result;
    }
}
