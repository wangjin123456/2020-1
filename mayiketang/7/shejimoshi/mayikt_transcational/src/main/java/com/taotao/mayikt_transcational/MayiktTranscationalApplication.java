package com.taotao.mayikt_transcational;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.taotao.mayikt_transcational.mapper")
@SpringBootApplication
public class MayiktTranscationalApplication {

    public static void main(String[] args) {
        SpringApplication.run(MayiktTranscationalApplication.class, args);
    }

}
