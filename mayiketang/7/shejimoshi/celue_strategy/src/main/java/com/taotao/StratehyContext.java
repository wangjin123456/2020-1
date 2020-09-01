package com.taotao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.taotao.msg.mapper.StrategyMapper;
import com.taotao.msg.mapper.entity.MeiteStrategy;
import com.taotao.strategy.MsgStrategy;
import com.taotao.utils.SpringUtils;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *@author tom
 *Date  2020/6/1 0001 7:23
 *
 */
@Component
public class StratehyContext {
    @Autowired
    private StrategyMapper strategyMapper;

    public <T> T getStrategy(String strategyId, Class<T> t) {
        if (Strings.isBlank(strategyId)) {
            return null;
        }
        return SpringUtils.getBean(strategyId, t);

    }

    public <T> T getStrategy(String strategyId, String strategyType, Class<T> t) {
        if (Strings.isBlank(strategyId)) {
            return null;
        }
        if (Strings.isBlank(strategyType)) {
            return null;
        }
        if (t == null) {
            return null;
        }
        // 根据策略id查询
        QueryWrapper<MeiteStrategy> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("strategy_ID", strategyId);
        queryWrapper.eq("strategy_type", strategyType);
        MeiteStrategy meiteStrategy = strategyMapper.selectOne(queryWrapper);
               if(null==meiteStrategy){
                   return  null;
               }
        return SpringUtils.getBean(meiteStrategy.getStrategyBeanId(), t);

    }
}
