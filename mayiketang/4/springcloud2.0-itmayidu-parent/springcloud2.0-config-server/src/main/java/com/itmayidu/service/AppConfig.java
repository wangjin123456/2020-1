package com.itmayidu.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 *@author tom
 *Date  2020/4/28 0028 14:35
 *
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})//忽略数据加载源
@EnableDiscoveryClient
@EnableConfigServer
public class AppConfig {
    public static void main(String[] args) {
        SpringApplication.run(AppConfig.class,args);
    }
}
