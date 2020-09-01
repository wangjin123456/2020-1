package com.taotao.jvm1.day07;

import lombok.Data;

/**
 *@author tom
 *Date  2020/8/17 0017 10:27
 *
 */
@Data
public class UserEntity {
    private  String name;

    public UserEntity(String name) {
        this.name = name;
    }
}
