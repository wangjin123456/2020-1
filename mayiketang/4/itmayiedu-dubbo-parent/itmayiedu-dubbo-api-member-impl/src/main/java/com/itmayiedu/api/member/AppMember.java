package com.itmayiedu.api.member;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *@author tom
 *Date  2020/5/2 0002 21:09
 *
 */
@SpringBootApplication
@EnableDubbo
public class AppMember {
    public static void main(String[] args) {
        SpringApplication.run(AppMember.class,args);
    }
}
