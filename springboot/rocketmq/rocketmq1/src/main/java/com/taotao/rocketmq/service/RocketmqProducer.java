package com.taotao.rocketmq.service;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.stereotype.Service;


import java.rmi.RemoteException;

/**
 * 创建provider
 * @autor tom
 * @date 2020/3/22 0022 8:07
 */
@Service
public class RocketmqProducer {
    /**
     * 使用 RocketMQ 原生的API进行消息发送
     * @param message
     * @throws MQClientException
     * @throws RemoteException
     * @throws RemotingException
     * @throws InterruptedException
     * @throws MQBrokerException
     */
    public  void send(String message) throws MQClientException, RemoteException, RemotingException, InterruptedException, MQBrokerException {
        DefaultMQProducer producer =new DefaultMQProducer("test_producer");
            producer.setNamesrvAddr("127.0.0.1:9876");
             producer.start();
        Message msg=new Message("test-topic","test-tag",message.getBytes());
        producer.send(msg);

    }
}
