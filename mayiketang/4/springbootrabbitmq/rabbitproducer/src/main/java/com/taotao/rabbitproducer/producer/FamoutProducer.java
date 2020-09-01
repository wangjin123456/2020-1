package com.taotao.rabbitproducer.producer;

import java.util.UUID;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;

/**
 *@author tom
 *Date  2020/5/13 0013 14:03
 *发送消息
 */
@Component
public class FamoutProducer {

    @Autowired
    private AmqpTemplate amqpTemplate;



    public  void send(String queueName){
        System.out.println("queuename:"+queueName);
        JSONObject jsonObject =new JSONObject();
        jsonObject.put("email","999999");
        jsonObject.put("timestamp",0);
        String jsonString=jsonObject.toJSONString();
        System.out.println("jsonObject:"+jsonString);
        //生产者发送消息时候需要设置全局id
        Message message = MessageBuilder.withBody(jsonString.getBytes())
                .setContentType(MessageProperties.CONTENT_TYPE_JSON).setContentEncoding("utf-8")
                .setMessageId(UUID.randomUUID() + "").build();

        amqpTemplate.convertAndSend(queueName, message);
    }
}
