package com.taotao.zerenlain.controller;

import com.taotao.zerenlain.response.handler.factory.DbHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *@author tom
 *Date  2020/6/5 0005 8:29
 *
 */
@RestController
public class HandlerController {

    @Autowired
    private DbHandler dbHandler;
    @RequestMapping("/")
    public  void getHandler(){
         dbHandler.getFirstGatewayHandler().doservice();

    }
}
