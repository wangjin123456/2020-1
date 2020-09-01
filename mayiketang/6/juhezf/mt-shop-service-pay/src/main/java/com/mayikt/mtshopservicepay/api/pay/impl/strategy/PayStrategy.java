package com.mayikt.mtshopservicepay.api.pay.impl.strategy;

import com.mayikt.mtshopservicepay.api.pay.impl.entity.PaymentChannelEntity;
import com.mayikt.mtshopservicepay.api.pay.impl.entity.PaymentTransactionEntity;

/**
 *@author tom
 *Date  2020/4/21 0021 11:03
 *
 */
public interface PayStrategy {
    /**
     * 聚合支付共同抽象的行为
     */
    String toPayHtml(PaymentChannelEntity pce, PaymentTransactionEntity pte);
}
