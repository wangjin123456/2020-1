package com.taotao.rabbitconsumer.msg.email;

import com.alibaba.fastjson.JSONObject;
import com.rabbitmq.client.Channel;
import com.taotao.rabbitconsumer.util.HttpClientUtils;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.stereotype.Component;


import java.util.Map;

/**
 *@author tom
 *Date  2020/5/13 0013 16:36
 *
 */
@Component

public class EmailConsumer {
    //rabbitmq 默认情况下如果消费者程序出现异常的情况下，会自动实现补偿机制
    //补偿（重试机制），队列服务器发送补偿请求
    //如果消费者程序业务逻辑出现异常消息不会消费
 /*   @RabbitHandler
    public  void process(String msg) throws Exception {
        System.out.println("邮件的消费者获取生产者消息消费msg:"+ msg);
        JSONObject jsonObject=JSONObject.parseObject(msg);
        String email=jsonObject.getString("email");
       String emailUrl="http://127.0.0.1:8083/sendEmail?email="+email;
        System.out.println("开始调用第三方邮件服务："+email);
      JSONObject result=  HttpClientUtils.httpGet(emailUrl);
        if(result ==null){
            throw new Exception("调用第三方邮件服务失败");
        }
        System.out.println("调用第三方服务成功：result="+result+"程序结束运行");
    }*/
    //rabbitmqListener 底层使用aop进行消费，如果程序员没有跑出异常，自动提交事务
    //如果aop 使用异常通知拦截的话，自动实现补偿机制，该消息会缓存到rabbitmq服务器进行存放，一直重试知道成功

    //修改默认机制策略。一般情况下间隔5秒重试一次
    //mq重试机制注意的问题：
/*    @RabbitListener(queues = "new_fanout_eamil_queue")
    public  void process(Message message, @Headers Map<String,Object>headers, Channel channel) throws Exception {
        System.out.println("邮件的消费者获取生产者消息消费msg:"+ message);
        String messageId=message.getMessageProperties().getMessageId();
        String msg=new String(message.getBody(),"utf-8");
        System.out.println("邮件的消费者获取生产者消息消费msg:"+ msg+"消息id:"+messageId);
        JSONObject jsonObject=JSONObject.parseObject(msg);
        String email=jsonObject.getString("email");
        String emailUrl="http://127.0.0.1:8083/sendEmail?email="+email;
        System.out.println("开始调用第三方邮件服务："+email);
        JSONObject result=  HttpClientUtils.httpGet(emailUrl);
        if(result ==null){
            throw new Exception("调用第三方邮件服务失败");
        }
        System.out.println("调用第三方服务成功：result="+result+"程序结束运行");
        //手动ack
        Long deliveryTag=(Long)headers.get(AmqpHeaders.DELIVERY_TAG);
        //手动牵收
        channel.basicAck(deliveryTag,false);
    }*/
    @RabbitListener(queues = "new_fanout_eamil_queue")
    public  void process(Message message, @Headers Map<String,Object>headers, Channel channel) throws Exception {
        System.out.println("邮件的消费者获取生产者消息消费msg:"+ message);
        String messageId=message.getMessageProperties().getMessageId();
        String msg=new String(message.getBody(),"utf-8");
        System.out.println("邮件的消费者获取生产者消息消费msg:"+ msg+"消息id:"+messageId);
        JSONObject jsonObject=JSONObject.parseObject(msg);
          Integer timestamp=jsonObject.getInteger("timestamp");
        try {
            int result=1/timestamp;
            //手动ack
            Long deliveryTag=(Long)headers.get(AmqpHeaders.DELIVERY_TAG);
            //手动牵收
            channel.basicAck(deliveryTag,false);
        }catch (Exception e){
            //拒绝消息消费（丢失消息）
            channel.basicNack(message.getMessageProperties().getDeliveryTag(),false,false);
             e.getCause();
        }

    }
}
