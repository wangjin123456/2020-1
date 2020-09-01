package com.taotao.springbootthread.entity;

import lombok.Data;

/**
 * @ClassName UserEntity
 * @Author 蚂蚁课堂余胜军 QQ644064779 www.mayikt.com
 * @Version V1.0
 **/
@Data
public class UserEntity {
    private Integer userId;
    private String userName;
    private String userPwd;

    public UserEntity(String userName, String userPwd) {
        this.userName = userName;
        this.userPwd = userPwd;
    }

    public UserEntity() {

    }
}
