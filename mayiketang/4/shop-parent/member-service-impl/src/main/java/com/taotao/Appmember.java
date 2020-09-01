package com.taotao;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 *@author tom
 *Date  2020/5/5 0005 7:44
 *
 */
@EnableEurekaClient
@EnableSwagger2Doc
@EnableFeignClients
@SpringBootApplication
public class Appmember {
    public static void main(String[] args) {
        SpringApplication.run(Appmember.class,args);
    }
}
