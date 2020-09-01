package com.taotao.rabbitmq.utils;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 *@author tom
 *Date  2020/5/12 0012 8:11
 *
 */
public class Consumer {
    //队列名称
    private  static  final  String QUEVE_NAME="222";

    public static void main(String[] args) {
        //创建一个连接队列
        try {
            Connection connection =MQConnectionUtils.newConnection();
            //2创建通道
            Channel channel=connection.createChannel();
            //3 消费者关联队列
            channel.queueDeclare(QUEVE_NAME,false,false,false,null);
              channel.basicQos(1);
            DefaultConsumer defaultConsumer=new DefaultConsumer(channel){
                //监听收到消息

                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                   String msg=new String(body,"utf-8");
                    System.out.println("消费者领取消息："+msg);
                   // 手动应答模式告诉队列是否已经创建成功
                channel.basicAck(envelope.getDeliveryTag(), false);

                }
            };
            //4, 设置应答模式,设置true表示自动应答模式
            channel.basicConsume(QUEVE_NAME,false,defaultConsumer);


            //关闭连接
         //   channel.close();
           // connection.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }




}
