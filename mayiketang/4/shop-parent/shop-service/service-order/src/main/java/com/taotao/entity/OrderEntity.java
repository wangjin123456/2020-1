package com.taotao.entity;

import lombok.Data;

import java.util.Date;

/**
 *@author tom
 *Date  2020/5/4 0004 21:56
 *
 */
@Data
public class OrderEntity {

    private Long id;
    // 订单名称
    private String name;
    // 订单时间
    private Date orderCreatetime;
    // 下单金额
    private Double orderMoney;
    // 订单状态
    private int orderState;
    // 商品id
    private Long commodityId;

}
