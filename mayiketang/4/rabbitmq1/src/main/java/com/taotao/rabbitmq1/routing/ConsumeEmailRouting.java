package com.taotao.rabbitmq1.routing;

import com.rabbitmq.client.*;
import com.sun.corba.se.impl.orbutil.threadpool.TimeoutException;
import com.taotao.rabbitmq1.utils.MQConnectionUtils;

import java.io.IOException;

/**
 *@author tom
 *Date  2020/5/12 0012 20:01
 *
 */
public class ConsumeEmailRouting {
    private static final String Email_QUEUE = "email_queue_rout";
    //交换机名称
    private static final String DESTINATION_NAME = "my_rout_estination";


    public static void main(String[] args) throws IOException, TimeoutException, java.util.concurrent.TimeoutException {
        System.out.println("邮件启动");
        //1, 建立mq连接
        Connection connection = MQConnectionUtils.newConnection();
        //2 创建通道
        Channel channel = connection.createChannel();
        //3,声明队列
        channel.queueDeclare(Email_QUEUE,false,false,false,null);
        //4消费队列绑定交换机
        channel.queueBind(Email_QUEUE,DESTINATION_NAME,"email");
        //5监听消息
     DefaultConsumer defaultConsumer=   new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
            String msg=new String(body,"UTF-8");
                System.out.println("邮件启动获取生产消息："+msg);
            }
        };
        channel.basicConsume(Email_QUEUE,true,defaultConsumer);


    }
}