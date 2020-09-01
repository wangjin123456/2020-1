package com.taotao.service;

import java.util.Comparator;
import java.util.Objects;

/**
 * @ClassName UserEntity
 * @Author 蚂蚁课堂余胜军 QQ644064779 www.mayikt.com
 * @Version V1.0
 **/
public class UserEntity {
    public String userName;
    public Integer age;

    public UserEntity(String userName, Integer age) {
        this.userName = userName;
        this.age = age;
    }

    @Override
    public String toString() {
        return "userName:" + userName + ",age:" + age;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, age);
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        return true;
    }

    //    @Override
//    public int compareTo(UserEntity o) {
//        return this.getAge() - o.getAge();
//    }
    public UserEntity setLimit() {
        return this;
    }
}
