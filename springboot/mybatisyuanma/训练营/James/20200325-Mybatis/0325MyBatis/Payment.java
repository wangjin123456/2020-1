package com.gupaoedu.mybatis.pattern;

/**
 * 支付
 */
public interface Payment {
    PayResponse payment(PaymentRequest request);
}
