package com.taotao.pay.strategy.impl;

import com.taotao.pay.strategy.PayStrategy;

/**
 *@author tom
 *Date  2020/6/1 0001 0:09
 *
 */
public class UnionPayStrategy implements PayStrategy {
    @Override
    public String toHtml() {
        return "对接银联";
    }
}
