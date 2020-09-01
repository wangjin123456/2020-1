package com.taotao.springbootthread;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * 实现一步发送短信
 */
@EnableAsync
@SpringBootApplication
public class SpringbootThreadApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootThreadApplication.class, args);
    }

}
