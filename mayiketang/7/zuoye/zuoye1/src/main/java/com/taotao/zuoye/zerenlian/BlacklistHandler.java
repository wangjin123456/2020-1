package com.taotao.zuoye.zerenlian;

import lombok.extern.slf4j.Slf4j;

/**
 *@author tom
 *Date  2020/7/14 0014 8:03
 *
 */
@Slf4j
public class BlacklistHandler extends GatewayHandler {
    public BlacklistHandler(GatewayHandler gatewayHandler) {
        super(gatewayHandler);
    }

    @Override
    public void doservice() {
        log.info(">>>第二关黑名单拦截");
        nextService();
    }
}
