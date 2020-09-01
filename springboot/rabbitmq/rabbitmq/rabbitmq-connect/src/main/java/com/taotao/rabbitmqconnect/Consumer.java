package com.taotao.rabbitmqconnect;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @autor tom
 * 创建消费者
 * @date 2020/3/1 0001  20:07
 */
public class Consumer {
    private  static  final  String QUEUE_NAME="hello";
    public static void main(String[] args) throws IOException, TimeoutException {
        System.out.println("消费者启动成功");
        //1，创建我们的连接
        Connection connection = RabbitmqConnectApplication.getConnection();
        //2,创建我们的通道
        Channel channel = connection.createChannel();
        DefaultConsumer defaultConsumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String msg = new String(body, "UTF-8");
                System.out.println("消费者消费消息" + msg);
            }
        };
        //创建我们的监听的消息
        channel.basicConsume(QUEUE_NAME, true, defaultConsumer);
        channel.close();
        connection.close();
    }

    }

