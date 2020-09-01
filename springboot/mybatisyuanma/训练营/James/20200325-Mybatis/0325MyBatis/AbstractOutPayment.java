package com.gupaoedu.mybatis.pattern;

/**
 * 国外支付模板
 */
public abstract class AbstractOutPayment implements Payment{
    public PayResponse pay(PaymentRequest request) {
        //log("国外");
        prePayment();
        v(request);
        postPayment();
        //4postPayment();
        return null;
    }

    public abstract void prePayment();
    public abstract void postPayment();
}
