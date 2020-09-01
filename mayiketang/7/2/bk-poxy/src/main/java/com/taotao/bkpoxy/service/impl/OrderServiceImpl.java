package com.taotao.bkpoxy.service.impl;

import com.taotao.bkpoxy.service.OrderService;

/**
 *@author tom
 *Date  2020/7/1 0001 22:50
 *
 */
public class OrderServiceImpl implements OrderService {
    @Override
    public String addOrder(String orderId, String orderName) {
        System.out.println("日志打印orderId："+orderId+",Ordername:"+orderId);
        return orderId+","+orderName;
    }
}
