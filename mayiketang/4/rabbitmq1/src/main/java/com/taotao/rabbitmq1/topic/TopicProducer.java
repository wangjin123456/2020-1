package com.taotao.rabbitmq1.topic;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.sun.corba.se.impl.orbutil.threadpool.TimeoutException;
import com.taotao.rabbitmq1.utils.MQConnectionUtils;

import java.io.IOException;


/**
 * 生产者交换机类型 producerfamout类型
 *@author tom
 *Date  2020/5/12 0012 19:47
 *通配符模式
 */
public class TopicProducer {
    // 交换机名称
    private static final String DESTINATION_NAME = "my_topic_estination";

    public static void main(String[] args) throws IOException, TimeoutException, java.util.concurrent.TimeoutException {
        // 1. 建立mq连接
        Connection connection = MQConnectionUtils.newConnection();
        // 2.创建通道
        Channel channel = connection.createChannel();
        // 3.生产者绑定交换机 参数1 交换机名称 参数2 交换机类型
        channel.exchangeDeclare(DESTINATION_NAME, "topic");
        String routingkey="log.sms";
        // 4.创建消息
        String msg = "my_topic_destination_msg"+routingkey;
        System.out.println("生产者投递消息:" + msg);
        // 5.发送消息 my_fanout_estination routingKey
        channel.basicPublish(DESTINATION_NAME, routingkey, null, msg.getBytes());
        // 6.关闭通道 和连接
        channel.close();
        connection.close();

    }

}
