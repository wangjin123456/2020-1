package com.itmayidu.springcloud_2_0_eureka_server_9001;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author Administrator
 */
@EnableEurekaServer
@SpringBootApplication
public class Springcloud20EurekaServer9001Application {

    public static void main(String[] args) {
        SpringApplication.run(Springcloud20EurekaServer9001Application.class, args);
    }

}
