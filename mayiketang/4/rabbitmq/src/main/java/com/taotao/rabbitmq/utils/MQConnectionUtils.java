package com.taotao.rabbitmq.utils;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.net.ConnectException;
import java.util.concurrent.TimeoutException;

/**
 *@author tom
 *Date  2020/5/12 0012 7:45
 *
 */
public class MQConnectionUtils {
    //创建mq的连接
    public static Connection newConnection() throws IOException, TimeoutException {
        //1,创建连接工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();
        //2设置连接
        connectionFactory.setHost("127.0.0.1");
        //设置用户名称
        connectionFactory.setUsername("wj");
        connectionFactory.setPassword("123456");
        //设置amq的端口号
        connectionFactory.setPort(5672);
        //设置virtulhost 地址admin_host
        connectionFactory.setVirtualHost("/wj");
        Connection connection = connectionFactory.newConnection();
        return connection;

    }

}
