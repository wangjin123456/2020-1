package com.taotao.zuoye.guangchazhe.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.taotao.zuoye.guangchazhe.service.MayiktObserver;
import org.springframework.stereotype.Component;

/**
 *@author tom
 *Date  2020/7/11 0011 8:31
 *
 */
@Component
public class EmailServer implements MayiktObserver {
    @Override
    public void sendMsg(JSONObject jsonObject) {
        System.out.println(Thread.currentThread().getName() + "2,邮件观察者监听");
    }
}
