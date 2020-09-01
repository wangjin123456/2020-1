package com.taotao.rabbitmq.utils;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 *@author tom
 *Date  2020/5/12 0012 7:57
 *创建生产者
 */
public class Producer {
    //队列名称
    private  static  final  String QUEVE_NAME="222";

    public static void main(String[] args) {
        //创建一个连接队列
        try {
            Connection connection =MQConnectionUtils.newConnection();
            //2创建通道
            Channel channel=connection.createChannel();
            //3 创建队列
            channel.queueDeclare(QUEVE_NAME,false,false,false,null);
            //4 msg

            for (int i = 0; i <10 ; i++) {
                String msg="io98998i"+i;
                System.out.println("生产者投递消息"+i);
                //5 生产者发送消息
                channel.basicPublish("",QUEVE_NAME,null,msg.getBytes());
            }

            //关闭连接
            channel.close();
            connection.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }




}
