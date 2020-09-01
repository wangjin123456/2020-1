package com.taotao.rabbitmqconnect;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 创建生产者
 */
public class Producer {
    /**
     * 提前新建一个队列 hello
     */
    private  static  final  String QUEUE_NAME="hello";
    public static void main(String[] args) throws IOException, TimeoutException {
        System.out.println("生产者启动成功");
        //1，创建我们的连接
        Connection connection =RabbitmqConnectApplication.getConnection();
          //2,创建我们的通道
        Channel channel =connection.createChannel();
        for (int i = 0; i <10 ; i++) {
            String msg="world";
            channel.basicPublish("",QUEUE_NAME,null,msg.getBytes());
            System.out.println("生产者发送消息成功："+ msg+i);
        }

        connection.close();
    }
}
