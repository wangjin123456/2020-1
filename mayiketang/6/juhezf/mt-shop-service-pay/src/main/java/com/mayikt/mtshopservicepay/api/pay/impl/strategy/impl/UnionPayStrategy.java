package com.mayikt.mtshopservicepay.api.pay.impl.strategy.impl;

import com.mayikt.mtshopservicepay.api.pay.impl.entity.PaymentChannelEntity;
import com.mayikt.mtshopservicepay.api.pay.impl.entity.PaymentTransactionEntity;
import com.mayikt.mtshopservicepay.api.pay.impl.strategy.PayStrategy;

/**
 *@author tom
 *Date  2020/4/21 0021 11:10
 *
 */
public class UnionPayStrategy  implements PayStrategy {
    @Override
    public String toPayHtml(PaymentChannelEntity pce, PaymentTransactionEntity pte) {
        return null;
    }
}
