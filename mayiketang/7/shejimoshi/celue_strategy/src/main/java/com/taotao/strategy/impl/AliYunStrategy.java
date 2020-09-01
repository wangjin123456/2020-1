package com.taotao.strategy.impl;

import com.taotao.strategy.MsgStrategy;
import org.springframework.stereotype.Component;

/**
 *@author tom
 *Date  2020/6/1 0001 0:04
 *
 */
@Component
public class AliYunStrategy  implements MsgStrategy {
    @Override
    public String sendMsg(String phone) {
        return "使用阿里云发送短信";
    }
}
