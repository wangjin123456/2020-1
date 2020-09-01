package com.taotao.zuoye.guangchazhe.service.config;

import com.taotao.zuoye.guangchazhe.service.entity.UserMessageEntity;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 *@author tom
 *Date  2020/7/11 0011 9:33
 *定义事件通知
 */
@Component
public class EmailListener implements ApplicationListener<UserMessageEntity> {
    @Override
    public void onApplicationEvent(UserMessageEntity userMessageEntity) {
        System.out.println("email:" + userMessageEntity.toString());

    }
}
