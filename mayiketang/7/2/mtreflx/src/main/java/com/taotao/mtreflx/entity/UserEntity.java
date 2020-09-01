package com.taotao.mtreflx.entity;

/**
 * @ClassName UserEntity
 * @Author 蚂蚁课堂余胜军 QQ644064779 www.mayikt.com
 * @Version V1.0
 **/
public class UserEntity {
    private String userName;
    private Integer userId;

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }
    public UserEntity(String userName) {
        this.userName=userName;
        System.out.println(">>>无参构造函数<<<");
    }
    public UserEntity() {
        System.out.println(">>>无参构造函数<<<");
    }

    public UserEntity(String userName, Integer userId) {
        this.userName = userName;
        this.userId = userId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    private void addUser(String userName) {
        System.out.println(">>addUser()<<< userName:" + userName);
    }
}
