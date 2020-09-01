package com.taotao.rabbitmqconsumer.config;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 加上消息消费类
 * @autor tom
 * @date 2020/3/19 0019 19:23
 */
@Component
@RabbitListener(queues = "fanout.C")
public class FanoutReceiverC {

    @RabbitHandler
    public  void process(Map testMessage){
        System.out.println("FamoutReceiverC消费者收到消息："+ testMessage.toString());
    }
}
