package com.taotao.rabbitmq1.amqp;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.sun.corba.se.impl.orbutil.threadpool.TimeoutException;
import com.taotao.rabbitmq1.utils.MQConnectionUtils;

import java.io.IOException;


/**
 * 消息队列回滚机制
 *@author tom
 *Date  2020/5/12 0012 19:47
 *通配符模式
 */
public class AmqpProducer {
    // 交换机名称
    private static final String QUEUE_NAME = "test_queue";

    public static void main(String[] args) throws IOException, TimeoutException, java.util.concurrent.TimeoutException {
        // 1. 建立mq连接
        Connection connection = MQConnectionUtils.newConnection();
        // 2.创建通道
        Channel channel = connection.createChannel();
        // 3.创建队列声明
        channel.queueDeclare(QUEUE_NAME, false,false,false,null);

      try {
          channel.txSelect();//开启事务机制
          // 4.创建消息
          String msg = "test_msg";
          System.out.println("生产者发送消息："+msg);
          // 5.发送消息 my_fanout_estination routingKey
          channel.basicPublish("",QUEUE_NAME, null, msg.getBytes());
          int  i=1/0;

         channel.txCommit();//提交事务
      } catch (Exception e){
          System.out.println("工厂事务回滚"+e);
          channel.txRollback();//事务回滚
      }finally {
          // 6.关闭通道 和连接

          channel.close();
          connection.close();
      }

    }

}
