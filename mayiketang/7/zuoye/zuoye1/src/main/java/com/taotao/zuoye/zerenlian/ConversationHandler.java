package com.taotao.zuoye.zerenlian;

import lombok.extern.slf4j.Slf4j;

/**
 *@author tom
 *Date  2020/7/14 0014 8:11
 *
 */
@Slf4j
public class ConversationHandler extends GatewayHandler {
    public ConversationHandler(GatewayHandler gatewayHandler) {
        super(gatewayHandler);
    }

    @Override
    public void doservice() {
        log.info(">>>>第三关判断用户的会话信息");
    }
}
