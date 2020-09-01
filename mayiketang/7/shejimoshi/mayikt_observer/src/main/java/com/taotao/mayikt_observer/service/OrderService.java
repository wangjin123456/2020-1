package com.taotao.mayikt_observer.service;

import com.alibaba.fastjson.JSONObject;
import com.taotao.mayikt_observer.entity.UserMessageEntity;
import com.taotao.mayikt_observer.observer.MayiktSubject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *@author tom
 *Date  2020/5/26 0026 23:41
 *
 */
@RestController
@Slf4j
public class OrderService {
    @Autowired
    private MayiktSubject mayiktSubject;
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @RequestMapping("/addOrder")
    public  String addOrder(){
        log.info("1，调用数据库下单订单代码");
        JSONObject jsonObject =new JSONObject();
        jsonObject.put("sms","1111111111");
        jsonObject.put("email","2222@qq.com");
        mayiktSubject.notifyObserver(jsonObject);
        return "success";
    }

    @RequestMapping("/addOrder2")
    public  String addOrder2(){
           log.info("1,调用数据库下单订单代码");
        UserMessageEntity userMessageEntity=new UserMessageEntity(this,"64","22","2");

       applicationEventPublisher.publishEvent(userMessageEntity);
        return "success";
    }

}
