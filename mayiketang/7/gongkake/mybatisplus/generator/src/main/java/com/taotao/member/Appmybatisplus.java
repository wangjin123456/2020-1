package com.taotao.member;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *@author tom
 *Date  2020/6/9 0009 9:15
 *
 */
@MapperScan("com.taotao.member.mapper")
@SpringBootApplication
public class Appmybatisplus {
    public static void main(String[] args) {
        SpringApplication.run(Appmybatisplus.class,args);
    }
}
