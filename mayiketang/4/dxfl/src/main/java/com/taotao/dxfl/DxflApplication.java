package com.taotao.dxfl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan(basePackages = "com.taotao.dxfl.mapper")
@SpringBootApplication
public class DxflApplication {

    public static void main(String[] args) {
        SpringApplication.run(DxflApplication.class, args);
    }

}
