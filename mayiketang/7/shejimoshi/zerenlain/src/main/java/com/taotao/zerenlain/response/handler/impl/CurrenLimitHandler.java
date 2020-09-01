package com.taotao.zerenlain.response.handler.impl;

import com.taotao.zerenlain.response.handler.GatewayHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *@author tom
 *Date  2020/6/5 0005 8:34
 *
 */
@Slf4j
@Component
public class CurrenLimitHandler extends GatewayHandler {
    public CurrenLimitHandler(GatewayHandler nextGatewayHandler) {
        super(nextGatewayHandler);
    }

    public CurrenLimitHandler() {


    }
    // @Autowired
  // private BlacklistHandler nextHandler;

    /*public CurrenLimitHandler(BlacklistHandler nextHandler) {
        this.nextHandler=nextHandler;
    }*/

    @Override
    public void doservice() {
         log.info("第一关ip限流的方法");
        nextGatewayHandler.doservice();
    }
}
