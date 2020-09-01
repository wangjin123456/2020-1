package com.taotao.zuoye.guangchazhe.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.taotao.zuoye.guangchazhe.service.MayiktObserver;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 *@author tom
 *Date  2020/7/11 0011 9:00
 *
 */
@Component
public class SmsObserver implements MayiktObserver {
    @Override
    public void sendMsg(JSONObject jsonObject) {
        System.out.println(Thread.currentThread().getName() + "1,短信观察者");
    }
}
