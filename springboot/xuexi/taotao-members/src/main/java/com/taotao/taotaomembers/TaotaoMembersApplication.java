package com.taotao.taotaomembers;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.taotao.taotaomembers.mapper")
@SpringBootApplication
public class TaotaoMembersApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaotaoMembersApplication.class, args);
    }

}
