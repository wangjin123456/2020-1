package com.taotao;

import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import com.spring4all.swagger.EnableSwagger2Doc;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 *@author tom
 *Date  2020/5/4 0004 22:34
 *
 */
@EnableDistributedTransaction
@EnableEurekaClient
@SpringBootApplication
@EnableFeignClients
public class AppStock {
    public static void main(String[] args) {
        SpringApplication.run(AppStock.class,args);
    }
}