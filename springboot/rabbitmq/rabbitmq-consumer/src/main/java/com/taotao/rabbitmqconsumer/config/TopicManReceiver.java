package com.taotao.rabbitmqconsumer.config;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @autor tom
 * @date 2020/3/19 0019 18:29
 */

@Component
@RabbitListener(queues = "topic.man")
public class TopicManReceiver {
    @RabbitHandler
    public void process(Map testMessage){
        System.out.println("TopicManReceiver消费者收到消息："+testMessage.toString());
    }
}
