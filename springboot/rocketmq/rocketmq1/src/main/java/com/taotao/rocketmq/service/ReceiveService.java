package com.taotao.rocketmq.service;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

/**
 * 创建consumer
 * @autor tom
 * @date 2020/3/22 0022 8:14
 */
@Service
public class ReceiveService {

    /**
     * 默认是input ，在sink类中指定，如果想要多个input，需要填写一个实现sink的类
     *
     */
    @StreamListener("input")
    public void receiveInput1(String receiveMessage){
        System.out.println("input receive:"+receiveMessage);
    }
}
