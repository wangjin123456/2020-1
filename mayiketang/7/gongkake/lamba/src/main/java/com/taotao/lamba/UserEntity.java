package com.taotao.lamba;

/**
 *@author tom
 *Date  2020/6/4 0004 9:49
 *
 */
public class UserEntity {
    private String username;
    private  int age;

    public UserEntity(String username, int age) {
        this.username = username;
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public UserEntity setUsername(String username) {
        this.username = username;
        return this;
    }

    public int getAge() {
        return age;
    }

    public UserEntity setAge(int age) {
        this.age = age;
        return this;
    }
}
