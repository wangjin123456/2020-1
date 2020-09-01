package com.taotao.rabbitconsumer.msg.email;

import com.alibaba.fastjson.JSONObject;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 *@author tom
 *Date  2020/5/13 0013 16:36
 *死信队列
 */
@Component
public class DeadQueueEmailConsumer {

    @RabbitListener(queues = "dead_queue")
    public  void process(Message message, @Headers Map<String,Object>headers, Channel channel) throws Exception {
        System.out.println("邮件的消费者获取生产者消息消费msg:"+ message);
        String messageId=message.getMessageProperties().getMessageId();
        String msg=new String(message.getBody(),"utf-8");
        System.out.println("死信队列邮件的消费者获取生产者消息消费msg:"+ msg+"消息id:"+messageId);

            //手动ack
            Long deliveryTag=(Long)headers.get(AmqpHeaders.DELIVERY_TAG);
            //手动牵收
            channel.basicAck(deliveryTag,false);


    }
}
