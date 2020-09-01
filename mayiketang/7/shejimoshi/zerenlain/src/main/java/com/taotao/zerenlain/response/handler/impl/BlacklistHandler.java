package com.taotao.zerenlain.response.handler.impl;

import com.taotao.zerenlain.response.handler.GatewayHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *@author tom
 *Date  2020/6/5 0005 8:37
 *
 */
@Slf4j
@Component
public class BlacklistHandler extends GatewayHandler {


    public BlacklistHandler(GatewayHandler nextGatewayHandler) {
        super(nextGatewayHandler);
    }

    public BlacklistHandler() {

    }

    @Override
    public void doservice() {
        log.info("第二关黑名单的处理业务逻辑判断");
        nextGatewayHandler.doservice();
    }
}
