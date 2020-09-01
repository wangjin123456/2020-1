package com.taotao.zuoye.guangchazhe.service.controller;

import com.alibaba.fastjson.JSONObject;
import com.taotao.zuoye.guangchazhe.service.config.MsyiktSubject;
import com.taotao.zuoye.guangchazhe.service.entity.UserMessageEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *@author tom
 *Date  2020/7/11 0011 9:14
 *
 */
@Slf4j
@RestController
public class ZhuangshizheController {


    @Autowired
    private MsyiktSubject mayiktSmsSubject;

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @RequestMapping("/addOrder")
    public String addOrder() {
        log.info("1,调用数据库下单订单代码");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("sms", "2222222");
        jsonObject.put("email", "33@qq.com");
        mayiktSmsSubject.notifyObserver(jsonObject);
        return "success";
    }

    @RequestMapping("/addOrder2")
    public String addOrder2() {
        log.info("1,调用数据库下单订单代码" + mayiktSmsSubject);
        UserMessageEntity messageEntity = new UserMessageEntity(this, "333@qq.com", "22222");

        applicationEventPublisher.publishEvent(messageEntity);
        return "success";

    }
}
