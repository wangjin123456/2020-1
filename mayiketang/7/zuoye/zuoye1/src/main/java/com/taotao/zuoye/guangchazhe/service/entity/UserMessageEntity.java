package com.taotao.zuoye.guangchazhe.service.entity;

import lombok.Data;
import org.springframework.context.ApplicationEvent;

/**
 *@author tom
 *Date  2020/7/11 0011 9:29
 *基于spring事件通知
 */

public class UserMessageEntity extends ApplicationEvent {
    private String email;
    private String phone;
    private String userId;


    public UserMessageEntity(Object source) {
        super(source);
    }

    public UserMessageEntity(Object source, String email, String phone) {
        super(source);
        this.email = email;
        this.phone = phone;

    }

    @Override
    public String toString() {
        return "UserMessageEntity{" +
                "email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getUserId() {
        return userId;
    }

    public UserMessageEntity setEmail(String email) {
        this.email = email;
        return this;
    }

    public UserMessageEntity setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public UserMessageEntity setUserId(String userId) {
        this.userId = userId;
        return this;
    }
}
