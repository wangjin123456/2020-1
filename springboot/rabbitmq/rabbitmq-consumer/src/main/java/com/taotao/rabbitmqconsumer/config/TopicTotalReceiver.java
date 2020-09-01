package com.taotao.rabbitmqconsumer.config;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @autor tom
 * @date 2020/3/19 0019 18:32
 */

@Component
@RabbitListener(queues = "topic.woman")
public class TopicTotalReceiver {

    @RabbitHandler
    public void process(Map testMessage){
        System.out.println("TopicTotalReceiver消费者收到的消息:"+ testMessage.toString());
    }
}
