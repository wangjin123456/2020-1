package com.taotao.rabbitmq1.utils;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * @author Administrator
 */
public class MQConnectionUtils {


    // 创建新的MQ连接
    public static Connection newConnection() throws IOException, TimeoutException {
        //创建mq的连接
            //1,创建连接工厂
            ConnectionFactory connectionFactory = new ConnectionFactory();
            //2设置连接
            connectionFactory.setHost("127.0.0.1");
            //设置用户名称
            connectionFactory.setUsername("guest");
            connectionFactory.setPassword("guest");
            //设置amq的端口号
            connectionFactory.setPort(5672);
            //设置virtulhost 地址admin_host
            connectionFactory.setVirtualHost("/yingying_rabbitmq");
            Connection connection = connectionFactory.newConnection();
            return connection;
    }

}
