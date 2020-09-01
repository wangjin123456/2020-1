package com.taotao.service;

import com.taotao.StratehyContext;
import com.taotao.strategy.MsgStrategy;
import com.taotao.strategy.factory.FactoryStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *@author tom
 *Date  2020/6/2 0002 7:02
 *
 */
@RestController
public class MsgService {
    @Autowired
    private StratehyContext stratehyContext;

    @RequestMapping("/senMsg")
    public String senMsg(String strategyId, String phone) {
        // MsgStrategy contextstrategy = FactoryStrategy.getMsgStrategy(strategyId);
       // MsgStrategy contextstrategy = stratehyContext.getStrategy(strategyId,MsgStrategy.class);
             MsgStrategy contextstrategy=stratehyContext.getStrategy(strategyId,"send_msg",MsgStrategy.class);
        if(contextstrategy ==null){
            return  "当前渠道已经关闭或者不存在";
        }
        return contextstrategy.sendMsg(phone);
    }
}
