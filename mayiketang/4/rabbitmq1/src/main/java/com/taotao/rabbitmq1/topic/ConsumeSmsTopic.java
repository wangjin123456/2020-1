package com.taotao.rabbitmq1.topic;

import com.rabbitmq.client.*;
import com.sun.corba.se.impl.orbutil.threadpool.TimeoutException;
import com.taotao.rabbitmq1.utils.MQConnectionUtils;

import java.io.IOException;

/**
 *@author tom
 *Date  2020/5/12 0012 20:01
 *通配符模式
 */
public class ConsumeSmsTopic {
    private static final String SMS_QUEUE = "sms_queue_topic";
    //交换机名称
    private static final String DESTINATION_NAME = "my_topic_estination";

    public static void main(String[] args) throws IOException, TimeoutException, java.util.concurrent.TimeoutException {
        System.out.println("短信启动");
        //1, 建立mq连接
        Connection connection = MQConnectionUtils.newConnection();
        //2 创建通道
        Channel channel = connection.createChannel();
        //3,声明队列
        channel.queueDeclare(SMS_QUEUE,false,false,false,null);

        //4消费队列绑定交换机可以绑定多个路由
        channel.queueBind(SMS_QUEUE,DESTINATION_NAME,"log.sms");
        channel.queueBind(SMS_QUEUE,DESTINATION_NAME,"log.email");
        //5监听消息
     DefaultConsumer defaultConsumer=   new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
            String msg=new String(body,"UTF-8");
                System.out.println("短信管理者获取生产消息："+msg);
            }
        };
        channel.basicConsume(SMS_QUEUE,true,defaultConsumer);


    }
}