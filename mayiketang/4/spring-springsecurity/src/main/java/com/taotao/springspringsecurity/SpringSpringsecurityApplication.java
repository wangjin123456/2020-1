package com.taotao.springspringsecurity;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan({"com.taotao.springspringsecurity.mapper"})
@SpringBootApplication
public class SpringSpringsecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSpringsecurityApplication.class, args);
    }

}
