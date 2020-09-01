package com.taotao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *@author tom
 *Date  2020/5/23 0023 23:40
 *
 */
@SpringBootApplication
@MapperScan("com.taotao.mapper")
public class AppChche {

    public static void main(String[] args) {
        SpringApplication.run(AppChche.class);
    }
}
