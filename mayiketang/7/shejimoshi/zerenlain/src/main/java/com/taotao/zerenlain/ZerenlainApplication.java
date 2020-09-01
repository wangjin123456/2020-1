package com.taotao.zerenlain;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.taotao.zerenlain.mapper")
@SpringBootApplication
public class ZerenlainApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZerenlainApplication.class, args);
    }

}
