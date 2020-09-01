package com.taotao.zuoye.celue.service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *@author tom
 *Date  2020/7/14 0014 8:41
 *
 */
public class FactoryStrategy {
    //存放策略的容器
    private static Map<String, MsgStrategy> strategyMap = new ConcurrentHashMap<String, MsgStrategy>();

    static {
        strategyMap.put("aliyunStrategy", new AliYunStrategy());
        strategyMap.put("tencentStrategy", new TencenStrategy());
        strategyMap.put("huaweiStrategy", new HuaWeiStrategy());
    }

    public static MsgStrategy getMsgStrategy(String strategyId) {
        return strategyMap.get(strategyId);
    }

    public static void main(String[] args) {
        FactoryStrategy factoryStrategy = new FactoryStrategy();
        getMsgStrategy("tencentStrategy").sendMsg();
    }


}
