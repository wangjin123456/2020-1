package com.mayikt.mtshopservicepay.api.pay.impl.entity;

import lombok.Data;

/**
 *@author tom
 *Date  2020/4/21 0021 14:53
 *
 */
@Data
public class PayOrderTokenDto {
    /**
     * 支付金额
     */
    private  long payAmount;
    /**
     * 订单号码
     */
    private  String orderId;
    /**
     * userId
     */
    private Long  userId;
    /**
     * 订单名称
     */
    private  String orderName;

}
