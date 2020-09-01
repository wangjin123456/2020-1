package com.taotao.zuoye.daili.service;

/**
 *@author tom
 *Date  2020/7/10 0010 18:06
 *
 */
public class OrderServiceImpl implements OrderService {
    @Override
    public String addOrder(String userName, String userPwd) {
        System.out.println("目标代理类");
        return userName + "," + userPwd;
    }
}
