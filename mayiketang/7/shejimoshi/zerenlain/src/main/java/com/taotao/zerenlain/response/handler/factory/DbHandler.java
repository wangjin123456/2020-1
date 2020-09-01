package com.taotao.zerenlain.response.handler.factory;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.taotao.zerenlain.entity.GatewayHandlerEntity;
import com.taotao.zerenlain.mapper.GatewayHandlerMapper;
import com.taotao.zerenlain.response.handler.GatewayHandler;
import com.taotao.zerenlain.utils.SpringUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *@author tom
 *Date  2020/6/5 0005 9:30
 *
 */
@Slf4j
@Component
public class DbHandler {
    @Autowired
    private GatewayHandlerMapper gatewayHandlerMapper;
    private GatewayHandler headGatewayHandler;

    public GatewayHandler getFirstGatewayHandler() {
        if (headGatewayHandler != null) {
            return headGatewayHandler;
        }
        //1 查询头部节点 Handler beanid 查询 prev_handler_id 是空的情况下表明为头节点
        QueryWrapper<GatewayHandlerEntity> objectQueryWrapper = new QueryWrapper<>();
        objectQueryWrapper.isNull("prev_handler_id");
        GatewayHandlerEntity gatewayHandlerEntity = gatewayHandlerMapper.selectOne(objectQueryWrapper);
        if (gatewayHandlerEntity == null) {
            log.error(">>>>很抱歉，您没有配置头结点");
            return null;
        }
        //2获取头结点的handlerid
        String handlerid = gatewayHandlerEntity.getHandlerId();
        if (Strings.isEmpty(handlerid)) {
            log.error(">>>>很抱歉，您没有配置头节点 hanlerid");
            return null;
        }
        //3 从容器获取handler对象
        GatewayHandler headgatewayHandler = SpringUtils.getBean(handlerid, GatewayHandler.class);
        if (headgatewayHandler == null) {
            log.error(">>>>您的代码里没有配置" + handlerid + ",对象");
            return null;
        }
        //4,能够成功获取权限流处理器，获取下一个处理器的beanid
        String nextHandlerid = gatewayHandlerEntity.getNextHandlerId();
        //记录当前循环值的对象
        GatewayHandler tempGatewayHandler = headgatewayHandler;
        while (Strings.isNotEmpty(nextHandlerid)) {
            //5,从spring里获取下一个接地啊对象
            GatewayHandler nextGatewayHandler = SpringUtils.getBean(nextHandlerid, GatewayHandler.class);

            if (nextHandlerid == null) {
                break;
            }
            QueryWrapper<GatewayHandlerEntity> nextquery = new QueryWrapper<>();
            nextquery.eq("handler_id", nextHandlerid);
            GatewayHandlerEntity nextgatewayHandlerEntity = gatewayHandlerMapper.selectOne(nextquery);
            if (nextgatewayHandlerEntity == null) {
                break;
            }
            nextHandlerid = nextgatewayHandlerEntity.getNextHandlerId();
            //    headgatewayHandler.setNextGatewayHandler(nextGatewayHandler);
            tempGatewayHandler.setNextGatewayHandler(nextGatewayHandler);
            tempGatewayHandler = nextGatewayHandler;
        }


        return headgatewayHandler;
    }
}
