package com.taotao.shardingjdbc.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 *@author tom
 *Date  2020/11/6 0006 8:27
 *
 */
@Data
@TableName("mayikt_user")
public class MayiktUser {
    private Integer id;
    private String name;
    private Integer age;

    public MayiktUser(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
