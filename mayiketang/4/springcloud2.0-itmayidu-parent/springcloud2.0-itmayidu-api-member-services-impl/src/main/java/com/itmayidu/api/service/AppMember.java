package com.itmayidu.api.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 *@author tom
 *Date  2020/4/21 0021 23:28
 *
 */
@EnableSwagger2//表示生成swagger2文档
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class AppMember {
    public static void main(String[] args) {
        SpringApplication.run(AppMember.class,args);
    }
}
