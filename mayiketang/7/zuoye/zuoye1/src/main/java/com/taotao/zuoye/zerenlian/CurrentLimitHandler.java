package com.taotao.zuoye.zerenlian;

import lombok.extern.slf4j.Slf4j;

/**
 *@author tom
 *Date  2020/7/14 0014 7:59
 *
 */
@Slf4j
public class CurrentLimitHandler extends GatewayHandler {
    public CurrentLimitHandler(GatewayHandler gatewayHandler) {
        super(gatewayHandler);
    }

    @Override
    public void doservice() {
        log.info(">>>>>>>>>>第一关api接口限流");
        nextService();
    }
}
