package com.taotao.zerenlain.response.handler.factory;

import com.taotao.zerenlain.response.handler.impl.BlacklistHandler;
import com.taotao.zerenlain.response.handler.impl.CurrenLimitHandler;
import com.taotao.zerenlain.response.handler.impl.TokenHandler;

/**
 *@author tom
 *Date  2020/6/5 0005 8:42
 *工厂handler
 */
public class FactoryHandler {

    public static CurrenLimitHandler getCurrentLimitHandler() {
        return new CurrenLimitHandler(new BlacklistHandler(new TokenHandler(null)));

    }

    public static CurrenLimitHandler getCurrentLimitHandler2() {
        CurrenLimitHandler currenLimitHandler = new CurrenLimitHandler();
        BlacklistHandler blacklistHandler = new BlacklistHandler();
        currenLimitHandler.setNextGatewayHandler(blacklistHandler);
        blacklistHandler.setNextGatewayHandler(new TokenHandler(null));
        return currenLimitHandler;
    }

    public static void main(String[] args) {
        CurrenLimitHandler currenLimitHandler = FactoryHandler.getCurrentLimitHandler2();
        currenLimitHandler.doservice();
    }
}
