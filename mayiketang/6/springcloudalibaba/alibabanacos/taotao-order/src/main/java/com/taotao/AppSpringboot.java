package com.taotao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 *@author tom
 *Date  2020/11/9 0009 13:38
 *
 */
@SpringBootApplication
public class AppSpringboot {
    public static void main(String[] args) {

        SpringApplication.run(AppSpringboot.class);
    }
       @LoadBalanced
    @Bean
    public RestTemplate restTemplate(){
        return  new RestTemplate();
    }
}
