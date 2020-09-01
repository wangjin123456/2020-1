package com.funtl.hello.spring.cloud.alibaba.rocketmq.consumer.service;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

/**
 * @autor tom
 * @date 2020/3/23 0023 17:25
 */
@Service
public class ConsumerReceive {
    @StreamListener("input")
    public void  receiveInput(String message){
        System.out.println("Receive  input :"+ message);
    }
}
