package com.taotao.threads.days08;

/**
 *@author tom
 *Date  2020/8/2 0002 9:36
 *
 */
public class OrderEntity {
    private int orderId;
    private  String orderName;

    public OrderEntity(int orderId, String orderName) {
        this.orderId = orderId;
        this.orderName = orderName;
    }

    public int getOrderId() {
        return orderId;
    }

    public OrderEntity setOrderId(int orderId) {
        this.orderId = orderId;
        return this;
    }

    public String getOrderName() {
        return orderName;
    }

    public OrderEntity setOrderName(String orderName) {
        this.orderName = orderName;
        return this;
    }
}
