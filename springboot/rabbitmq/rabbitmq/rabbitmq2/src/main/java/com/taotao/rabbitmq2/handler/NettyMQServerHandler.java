package com.taotao.rabbitmq2.handler;

import com.taotao.rabbitmq2.entity.DeliveryInfoEntity;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @autor tom
 * @date 2020/3/3 0003  22:07
 */
public class NettyMQServerHandler extends SimpleChannelInboundHandler<DeliveryInfoEntity> {
    //netty的服务器端接受客户端的消息 mq服务器端
    //mq存放所有的对列
    private Map<String, Queue> queues = new HashMap<>();

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, DeliveryInfoEntity msg) throws Exception {
        Boolean connType = msg.isConnType();
        String queueName=msg.getQueueName();
        if(StringUtils.isAllBlank(queueName)){
            return;
        }
        if (connType) {
//处理生产者角色
            producterService(queueName, msg.getMsg());
            return;
        }
        consumer(queueName,ctx);
    }

    private void producterService(String queueName, String msg) {
        Queue queue = queues.get(queueName);
        if (queue == null) {
            //如果不存在就创建
            queue = new LinkedList();
            queues.put(queueName, queue);
        }
        //将消息缓存到对列中
        queue.offer(msg);
    }

    /**
     * 消费和mq建立连接主动拉去消息
     * @param queueName
     * @param ctx
     */
    private void consumer(String queueName, ChannelHandlerContext ctx) {
        Queue queue = queues.get(queueName);
        if(queue==null){
            return;
        }
        //获取对列中的消息
        Object poll =queue.poll();
        ctx.writeAndFlush(poll);
    }

}
