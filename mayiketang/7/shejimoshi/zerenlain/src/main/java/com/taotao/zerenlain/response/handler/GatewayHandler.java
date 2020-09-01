package com.taotao.zerenlain.response.handler;

/**
 *@author tom
 *Date  2020/6/5 0005 8:24
 *
 */
public abstract class GatewayHandler {
    //每个不同的处理器处理的业务逻辑不同
    public  abstract   void doservice();

    protected  GatewayHandler nextGatewayHandler;

    public GatewayHandler(GatewayHandler nextGatewayHandler) {
        this.nextGatewayHandler = nextGatewayHandler;
    }

    public GatewayHandler() {
    }

    public GatewayHandler setNextGatewayHandler(GatewayHandler nextGatewayHandler) {
        this.nextGatewayHandler = nextGatewayHandler;
        return this;
    }
}
