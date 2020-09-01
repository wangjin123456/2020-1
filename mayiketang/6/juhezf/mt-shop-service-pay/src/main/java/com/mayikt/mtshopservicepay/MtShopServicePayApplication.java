package com.mayikt.mtshopservicepay;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.mayikt.mtshopservicepay.api.pay.impl.mapper")
@SpringBootApplication
public class MtShopServicePayApplication {

    public static void main(String[] args) {
        SpringApplication.run(MtShopServicePayApplication.class, args);
    }

}
