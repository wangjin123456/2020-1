package com.itmayido.springcloud_2_eureka_order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class Springcloud2EurekaOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springcloud2EurekaOrderApplication.class, args);
    }

     @LoadBalanced
    @Bean
    RestTemplate restTemplate(){
        return  new RestTemplate();
    }
}
