package com.taotao.mayikt_observer.entity;

import lombok.Data;
import org.springframework.context.ApplicationEvent;

/**
 *@author tom
 *Date  2020/5/27 0027 8:03
 *
 */

public class UserMessageEntity  extends ApplicationEvent {
    private String email;
    private String phone;
    private String userId;

    public UserMessageEntity(Object source) {
        super(source);
    }

    public UserMessageEntity(Object source, String email, String phone, String userId) {
        super(source);
        this.email = email;
        this.phone = phone;
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "UserMessageEntity{" +
                "email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
