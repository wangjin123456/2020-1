package com.taotao.strategy.impl;

import com.taotao.strategy.MsgStrategy;
import org.springframework.stereotype.Component;

/**
 *@author tom
 *Date  2020/6/2 0002 6:17
 *
 */
@Component
public class TencentStrategy  implements MsgStrategy {
    @Override
    public String sendMsg(String phone) {
        return "腾讯云";
    }
}
