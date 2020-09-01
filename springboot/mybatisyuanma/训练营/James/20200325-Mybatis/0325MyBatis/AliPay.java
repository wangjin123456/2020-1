package com.gupaoedu.mybatis.pattern;

public class AliPay extends AbstractBasePayment{

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