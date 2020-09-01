package com.taotao.bkproxy.service.impl;

import com.taotao.bkproxy.service.OrderService;

/**
 *@author tom
 *Date  2020/5/17 0017 23:25
 *
 */
public class OrderServiceImpl  implements OrderService {
    @Override
    public String addOrder(String orderId, String orderName) {
        System.out.println("addOrder方法"+orderId);
        return orderId+"-"+orderName;
    }
}
