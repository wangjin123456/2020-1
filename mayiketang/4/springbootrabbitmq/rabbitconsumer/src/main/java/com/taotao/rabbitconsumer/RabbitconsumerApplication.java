package com.taotao.rabbitconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@SpringBootApplication
public class RabbitconsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitconsumerApplication.class, args);
    }



}
