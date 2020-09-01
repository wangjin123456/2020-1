package com.taotao.zuoye.zerenlian;

/**
 *@author tom
 *Date  2020/7/14 0014 7:55
 *
 */
public abstract class GatewayHandler {
    //处理业务逻辑
    public abstract void doservice();

    private GatewayHandler gatewayHandler;

    public GatewayHandler(GatewayHandler gatewayHandler) {
        this.gatewayHandler = gatewayHandler;
    }

    protected void nextService() {
        if (gatewayHandler != null) {
            gatewayHandler.doservice();
        }
    }

}
