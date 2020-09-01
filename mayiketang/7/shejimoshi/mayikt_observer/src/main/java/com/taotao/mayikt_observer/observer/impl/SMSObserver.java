package com.taotao.mayikt_observer.observer.impl;

import com.alibaba.fastjson.JSONObject;
import com.taotao.mayikt_observer.observer.Observer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 *@author tom
 *Date  2020/5/26 0026 23:42
 *
 */
@Component
@Slf4j
public class SMSObserver  implements Observer {
    @Override
    public void sendMsg(JSONObject jsonObject) {
        System.out.println("使用观察者发送短信");
        log.info("使用观察者发送短信");
    }
}
