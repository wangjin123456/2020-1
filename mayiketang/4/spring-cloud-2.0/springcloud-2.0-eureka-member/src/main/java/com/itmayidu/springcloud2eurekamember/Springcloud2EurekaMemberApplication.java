package com.itmayidu.springcloud2eurekamember;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication

public class Springcloud2EurekaMemberApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springcloud2EurekaMemberApplication.class, args);
    }

}
