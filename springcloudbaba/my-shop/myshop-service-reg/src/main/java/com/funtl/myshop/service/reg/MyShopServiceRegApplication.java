package com.funtl.myshop.service.reg;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tk.mybatis.spring.annotation.MapperScan;
/**
 * @author Administrator
 *
 * @date 2020/3/26 0026 9:29
 */
@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = "com.funtl.myshop")
@MapperScan(basePackages = {"com.funtl.myshop.commons.mapper"})
@EnableBinding({Source.class})
@EnableAsync
@EnableSwagger2
public class MyShopServiceRegApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyShopServiceRegApplication.class,args);
    }
}
