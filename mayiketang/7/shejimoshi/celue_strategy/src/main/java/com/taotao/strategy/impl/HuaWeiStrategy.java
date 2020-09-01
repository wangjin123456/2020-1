package com.taotao.strategy.impl;

import com.taotao.strategy.MsgStrategy;
import org.springframework.stereotype.Component;

/**
 *@author tom
 *Date  2020/6/1 0001 0:05
 *
 */
@Component
public class HuaWeiStrategy implements MsgStrategy {
    @Override
    public String sendMsg(String phone) {
        return "使用华为发送短信";
    }
}
