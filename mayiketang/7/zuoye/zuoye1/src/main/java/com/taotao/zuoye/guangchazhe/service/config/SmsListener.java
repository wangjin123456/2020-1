package com.taotao.zuoye.guangchazhe.service.config;

import com.taotao.zuoye.guangchazhe.service.entity.UserMessageEntity;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 *@author tom
 *Date  2020/7/11 0011 9:38
 *
 */
@Component
public class SmsListener implements ApplicationListener<UserMessageEntity> {
    @Override
    public void onApplicationEvent(UserMessageEntity userMessageEntity) {
        System.out.println("sms" + userMessageEntity.toString());
    }
}
