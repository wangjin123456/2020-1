package com.funtl.myshop.service.provider.item;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author tom
 * @date 2020/3/31 0031 10:49
 */

@SpringBootApplication(scanBasePackages = "com.funtl.myshop")
@EnableDiscoveryClient
@EnableSwagger2
@MapperScan(basePackages = "com.funtl.myshop.commons.mapper")
public class MyShopServiceProviderItemApplication {


    public static void main(String[] args) {
        SpringApplication.run(MyShopServiceProviderItemApplication.class,args);

    }
}
