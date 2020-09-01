package com.gupaoedu.mybatis.pattern;

/**
 * 微信支付
 */
public class WxPayment extends AbstractBasePayment{
    @Override
    public void prePayment() {

    }

    @Override
    public void postPayment() {

    }

    @Override
    public PayResponse payment(PaymentRequest request) {
        return null;
    }
}