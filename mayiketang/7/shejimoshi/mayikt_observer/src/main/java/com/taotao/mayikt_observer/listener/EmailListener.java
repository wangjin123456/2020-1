package com.taotao.mayikt_observer.listener;

import com.taotao.mayikt_observer.entity.UserMessageEntity;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 *@author tom
 *Date  2020/5/27 0027 8:09
 *
 */
@Component
public class EmailListener  implements ApplicationListener<UserMessageEntity> {
    /**
     * 监听方法
     * @param userMessageEntity
     */
    @Override
    public void onApplicationEvent(UserMessageEntity userMessageEntity) {
        System.out.println("发送邮件消息"+userMessageEntity.toString());
    }
}
