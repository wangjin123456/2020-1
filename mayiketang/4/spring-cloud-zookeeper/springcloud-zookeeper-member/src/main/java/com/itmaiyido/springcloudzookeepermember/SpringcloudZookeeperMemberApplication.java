package com.itmaiyido.springcloudzookeepermember;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 */
@RestController
@EnableDiscoveryClient
@SpringBootApplication
public class SpringcloudZookeeperMemberApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudZookeeperMemberApplication.class, args);
    }

    @Value("${server.port}")
    private  String serverport;

    @RequestMapping("/getmember")
    public  String getMember(){
        return  "会员端的服务端口为："+serverport;
    }

}
