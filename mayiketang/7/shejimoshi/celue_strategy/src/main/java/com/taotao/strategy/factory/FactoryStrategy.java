package com.taotao.strategy.factory;

import com.taotao.strategy.MsgStrategy;
import com.taotao.strategy.impl.AliYunStrategy;
import com.taotao.strategy.impl.HuaWeiStrategy;
import com.taotao.strategy.impl.TencentStrategy;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *@author tom
 *Date  2020/6/1 0001 0:03
 *
 */
public class FactoryStrategy {

    /**
     * 存放策略的容器
     */
    private static Map<String, MsgStrategy> strategys = new ConcurrentHashMap<String, MsgStrategy>();

    static {
        strategys.put("aliYunStrategy", new AliYunStrategy());
        strategys.put("tencentStrategy", new TencentStrategy());
        strategys.put("huaWeiStrategy", new HuaWeiStrategy());
    }

    public static MsgStrategy getMsgStrategy(String strategyId) {
              return  strategys.get(strategyId);
    }
}
