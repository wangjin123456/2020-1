package com.taotao.mayikt_security2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.taotao.mayikt_security2.mapper")
@SpringBootApplication
public class MayiktSecurity2Application {

    public static void main(String[] args) {
        SpringApplication.run(MayiktSecurity2Application.class, args);
    }

}
