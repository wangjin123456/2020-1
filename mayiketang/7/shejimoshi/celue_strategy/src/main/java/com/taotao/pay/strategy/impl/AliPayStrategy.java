package com.taotao.pay.strategy.impl;

import com.taotao.pay.strategy.PayStrategy;
import org.springframework.stereotype.Component;

/**
 *@author tom
 *Date  2020/6/1 0001 0:07
 *
 */
@Component
public class AliPayStrategy  implements PayStrategy {
    @Override
    public String toHtml() {
        return "对接阿里";
    }
}
