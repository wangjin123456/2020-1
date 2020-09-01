package com.taotao.rabbitconsumer.msg.sms;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 *@author tom
 *Date  2020/5/13 0013 16:36
 *
 */
@Component
@RabbitListener(queues = "new_fanout_sms_queue")
public class SmsConsumer {
    //补偿重试机制，当消费端出现错误rabbitmq会不断的重试
    @RabbitHandler
    public  void process(String msg){
        System.out.println("短信的消费者获取生产者消息消费msg:"+ msg);
        int i=1/0;
    }
}
