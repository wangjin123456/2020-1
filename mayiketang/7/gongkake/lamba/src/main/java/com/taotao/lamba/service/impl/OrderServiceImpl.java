package com.taotao.lamba.service.impl;

import com.taotao.lamba.service.OrderServie;

/**
 *@author tom
 *Date  2020/6/3 0003 20:46
 *
 */
public class OrderServiceImpl implements OrderServie {
    @Override
    public void addOrder() {
        System.out.println("addOrder方法");
    }

    @Override
    public void getOrder() {

        System.out.println("getOrder子类");
    }
}
