package com.taotao.producer.controller;

import java.util.UUID;

import com.taotao.producer.stream.SendMessageInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *@author tom
 *Date  2020/5/19 0019 7:43
 *
 */

@RestController
public class SendMsgController {
    @Autowired
    private SendMessageInterface sendMessageInterface;

    //生产者流程：
    //1, 创建并发送消息
    //2.生产者投递消息（生产者往通道里发送消息）
    @RequestMapping("/sendMsg")
    public  String sendMsg(){
        String msg= UUID.randomUUID().toString();
        System.out.println("生产者发送内容msg:"+ msg);
        Message build= MessageBuilder.withPayload(msg.getBytes()).build();
         sendMessageInterface.sendMsg().send(build);
         return  "success";
    }

}
