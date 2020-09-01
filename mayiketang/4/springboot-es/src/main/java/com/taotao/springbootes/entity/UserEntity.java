package com.taotao.springbootes.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.lang.annotation.Documented;

/**
 *@author tom
 *Date  2020/5/23 0023 9:34
 *
 */
@Document(indexName = "taotao",type="user")
@Data
public class UserEntity {
    @Id
    private  String id;
    private  String name;
    private  Integer age;
    private  Integer sex;

}
