package com.taotao.rocketmq.controller;

import com.taotao.rocketmq.service.RocketmqProducer;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.rmi.RemoteException;

/**
 * @autor tom
 * @date 2020/3/22 0022 9:58
 */
@RestController
public class TestController {

    @Autowired
    RocketmqProducer rocketmqProducer;
    @GetMapping("/send")
    public  String send() throws InterruptedException, RemoteException, RemotingException, MQClientException, MQBrokerException {
        rocketmqProducer.send("tset rocketmq message");
        return "OK";
    }
}
