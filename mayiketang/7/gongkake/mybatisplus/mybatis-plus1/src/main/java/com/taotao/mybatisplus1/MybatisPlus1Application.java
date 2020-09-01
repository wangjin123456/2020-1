package com.taotao.mybatisplus1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.taotao.mybatisplus1.mapper")
@SpringBootApplication
public class MybatisPlus1Application {

    public static void main(String[] args) {
        SpringApplication.run(MybatisPlus1Application.class, args);
    }

}
