package com.taotao.zerenlain.response.handler.impl;

import com.taotao.zerenlain.response.handler.GatewayHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 *@author tom
 *Date  2020/6/5 0005 8:39
 *
 */
@Slf4j
@Component
public class TokenHandler extends GatewayHandler {

    public TokenHandler(GatewayHandler nextGatewayHandler) {
        super(nextGatewayHandler);
    }

    public TokenHandler() {

    }
    @Override
    public void doservice() {
        log.info(">>>>>>>>>>>第三关token");
    }
}
