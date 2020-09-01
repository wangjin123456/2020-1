package com.itmayido.springcloudconsulorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@EnableDiscoveryClient
@SpringBootApplication
public class SpringCloudConsulOrderApplication {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private DiscoveryClient discoveryClient;


    public static void main(String[] args) {
        SpringApplication.run(SpringCloudConsulOrderApplication.class, args);
    }

    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @RequestMapping("/orderToMember")
    public String orderToMember() {
        String memberurl = "http://consul-member/getmember";
        return restTemplate.getForObject(memberurl, String.class);
    }

    /**
     * 获取注册的一些信息
     * @return
     */
    @RequestMapping("/discoveryclient")
    public List<ServiceInstance> discoveryclient() {
        List<ServiceInstance> instances = discoveryClient.getInstances("consul-member");
        for (ServiceInstance s : instances
        ) {
            System.out.println("url:" + s.getUri());
        }
        return instances;
    }
}
