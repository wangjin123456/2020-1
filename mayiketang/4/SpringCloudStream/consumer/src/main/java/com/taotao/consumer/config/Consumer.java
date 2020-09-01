package com.taotao.consumer.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

/**
 *@author tom
 *Date  2020/5/19 0019 8:15
 *
 */
@Component
public class Consumer {
    @Value("${server.port}")
    private  String serverport;
    @StreamListener("my_stream_channel")
    public  void redMsg(String msg){
        System.out.println("消费者获取到生产者消息："+msg+serverport);
    }
}
