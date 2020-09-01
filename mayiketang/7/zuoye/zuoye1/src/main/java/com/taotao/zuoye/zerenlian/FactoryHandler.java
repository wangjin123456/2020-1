package com.taotao.zuoye.zerenlian;

/**
 *@author tom
 *Date  2020/7/14 0014 8:15
 *
 */
public class FactoryHandler {
    /**
     * 获取第一个currentlimitHandler
     */
    public static GatewayHandler getFIrstGatewayHanler() {
        CurrentLimitHandler currentLimitHandler = new CurrentLimitHandler(new BlacklistHandler(new ConversationHandler(null)));
        return currentLimitHandler;


    }

    public static void main(String[] args) {
        getFIrstGatewayHanler().doservice();
    }

}
