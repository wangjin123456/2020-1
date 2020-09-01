package com.taotao.rabbitmqconnect;


import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.net.ConnectException;
import java.util.concurrent.TimeoutException;

public class RabbitmqConnectApplication {


    public static Connection getConnection() throws IOException, TimeoutException {
        //1,创建我们的连接
        ConnectionFactory connectionFactory =new ConnectionFactory();
          //2 设置我们的连接地址
        connectionFactory.setHost("127.0.0.1");
         //3.设置我们的端口号
        connectionFactory.setPort(5672);
          //4设置账号和密码
        connectionFactory.setUsername("sy");
       connectionFactory.setPassword("aaaa1111");
       //5,设置virtualHost
        connectionFactory.setVirtualHost("/yingying_rabbitmq");
          return  connectionFactory.newConnection();
    }
}
