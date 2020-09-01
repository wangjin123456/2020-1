package com.taotao;
import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.spring4all.swagger.EnableSwagger2Doc;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 *@author tom
 *Date  2020/5/4 0004 22:06
 *
 */
@EnableDistributedTransaction
@MapperScan(basePackages = "com.taotao.mapper")
@EnableSwagger2
@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class AppOrder {
    public static void main(String[] args) {
        SpringApplication.run(AppOrder.class,args);
    }
}
