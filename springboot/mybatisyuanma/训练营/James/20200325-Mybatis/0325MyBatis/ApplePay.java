package com.gupaoedu.mybatis.pattern;


public class ApplePay extends AbstractOutPayment {
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
