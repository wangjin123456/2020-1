package com.taotao.service.impl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import service.IndexService;

/**
 *@author tom
 *Date  2020/5/1 0001 9:30
 *
 */
@RestController
public class IndexServiceImpl implements IndexService {
    private  String serverPort="20882";
    @GetMapping("/index")
    public String index() {
        System.out.println("生产者调用消费者");
        return "hello world";
    }
}
