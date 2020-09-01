package com.taotao.orderday105.service;

import java.util.UUID;

/**
 *@author tom
 *Date  2020/6/5 0005 21:32
 *
 */
public class OrderService {
    public static  String order(){
        String orderID= UUID.randomUUID().toString().replace("-","");
        return  orderID;
    }

    public static void main(String[] args) {
        System.out.println(order());
    }
}
