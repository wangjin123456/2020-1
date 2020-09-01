package com.gupaoedu.mybatis.pattern;

/**
 * 支付模板
 */

public abstract class AbstractBasePayment implements Payment{
    public PayResponse pay(PaymentRequest request) {
        //log("国内");
        prePayment();
        payment(request);
        postPayment();
        return null;
    }

    public abstract void prePayment();
    public abstract void postPayment();
}
