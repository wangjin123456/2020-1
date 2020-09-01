package com.itmaiyidu.springcloudzookeeperorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@EnableDiscoveryClient
@SpringBootApplication
public class SpringcloudZookeeperOrderApplication {
@Autowired
private RestTemplate restTemplate;
    public static void main(String[] args) {
        SpringApplication.run(SpringcloudZookeeperOrderApplication.class, args);
    }

    @Bean
    @LoadBalanced
    RestTemplate restTemplate(){
        return  new RestTemplate();
    }
    @RequestMapping("/orderToMember")
    public  String orderToMember(){
        String memberurl="http://zk-member/getmember";
        return  restTemplate.getForObject(memberurl,String.class);
    }
}
