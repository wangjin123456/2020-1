package com.taotao.rabbitproducer.controller;

import com.taotao.rabbitproducer.producer.FamoutProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *@author tom
 *Date  2020/5/13 0013 14:07
 *
 */
@RestController
public class ProducerController {
    @Autowired
    private FamoutProducer fanoutProducer;

    @RequestMapping("/sendFanout")
    public String sendFanout(String queueName) {
        fanoutProducer.send(queueName);
        return "success";
    }
}
