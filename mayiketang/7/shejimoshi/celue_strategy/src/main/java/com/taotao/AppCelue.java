package com.taotao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *@author tom
 *Date  2020/6/2 0002 6:13
 *
 */
@SpringBootApplication
@MapperScan("com.taotao.msg.mapper")
public class AppCelue {
    public static void main(String[] args) {
        SpringApplication.run(AppCelue.class,args);
    }
}
