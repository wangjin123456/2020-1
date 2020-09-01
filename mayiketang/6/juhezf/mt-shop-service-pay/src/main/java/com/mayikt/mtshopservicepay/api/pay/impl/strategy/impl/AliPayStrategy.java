package com.mayikt.mtshopservicepay.api.pay.impl.strategy.impl;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.mayikt.mtshopservicepay.api.pay.impl.alipay.config.AlipayConfig;
import com.mayikt.mtshopservicepay.api.pay.impl.entity.PaymentChannelEntity;
import com.mayikt.mtshopservicepay.api.pay.impl.entity.PaymentTransactionEntity;
import com.mayikt.mtshopservicepay.api.pay.impl.strategy.PayStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 *@author tom
 *Date  2020/4/21 0021 11:08
 *
 */
@Component
@Slf4j
public class AliPayStrategy implements PayStrategy {
    @Override
    public String toPayHtml(PaymentChannelEntity pce, PaymentTransactionEntity pte) {
        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(pce.getRequestAddress(),
                pce.getMerchantId(), pce.getPrivateKey(), "json",
                AlipayConfig.CHARSET, pce.getPublicKey(), AlipayConfig.SIGN_TYPE);
        //设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(pce.getSyncUrl());
        alipayRequest.setNotifyUrl(pce.getAsynUrl());
        String orderId = pte.getOrderId();
        alipayRequest.setBizContent("{\"out_trade_no\":\"" + pte.getPaymentId() + "\","
                + "\"total_amount\":\"" + pte.getPayAmount() / 100 + "\","
                + "\"subject\":\"" + pte.getOrderName() + "\","
                + "\"body\":\"" + pte.getOrderBody() + "\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
        try {
            String result = alipayClient.pageExecute(alipayRequest).getBody();

            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

