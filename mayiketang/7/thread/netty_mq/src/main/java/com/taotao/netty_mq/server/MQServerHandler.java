package com.taotao.netty_mq.server;

import com.alibaba.fastjson.JSONObject;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;
import org.apache.commons.lang3.StringUtils;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @ClassName MQServerHandler
 * @Author 蚂蚁课堂余胜军 QQ644064779 www.mayikt.com
 * @Version V1.0
 **/
public class MQServerHandler extends SimpleChannelInboundHandler {

    private static ConcurrentHashMap<String, LinkedBlockingDeque> concurrentHashMap = new ConcurrentHashMap<String, LinkedBlockingDeque>();
    private static ConcurrentHashMap<String, ChannelHandlerContext> channelhashMap =
            new ConcurrentHashMap<String, ChannelHandlerContext>();

    /**
     * netty客户端向netty服务器端发送消息 就会走该方法
     *
     * @param ctx
     * @param o
     * @throws Exception
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object o) throws Exception {
        // 接受我们的数据
        ByteBuf byteBuf = (ByteBuf) o;
        String request = byteBuf.toString(CharsetUtil.UTF_8);
        System.out.println("request:" + request);
        JSONObject msg = JSONObject.parseObject(request);
        String type = msg.getString("type");
        if (StringUtils.isEmpty(type)) {
            return;
        }
        String dequeName = msg.getString("dequeName");
        if (StringUtils.isEmpty(dequeName)) {
            return;
        }
        if ("producer".equals(type)) {
            // 生产者处理
            producerService(msg, dequeName);
            // 推送给消费者
            notifyConsumer(dequeName);
            return;
        }
        if ("consumer".equals(type)) {
            // 消费者处理
            consumerService(msg, ctx, dequeName);
            // 缓存我们消费者连接 优化改成多个消费者缓存
            channelhashMap.put(dequeName, ctx);
            return;
        }


//
//        // 响应内容:
//        ctx.writeAndFlush(Unpooled.copiedBuffer("平均突破3万月薪", CharsetUtil.UTF_8));


        // mayikt mq 协议

    }

    private void notifyConsumer(String dequeName) {
        ChannelHandlerContext consumerCtx = channelhashMap.get(dequeName);
        if (consumerCtx != null) {
            LinkedBlockingDeque<String> linkedBlockingDeque = concurrentHashMap.get(dequeName);
            if (linkedBlockingDeque == null) {
                return;
            }
            while (linkedBlockingDeque.size() > 0) {
                // 响应内容:
                String poll = linkedBlockingDeque.poll();
                if (StringUtils.isEmpty(poll)) {
                    return;
                }
                consumerCtx.writeAndFlush(Unpooled.copiedBuffer(poll, CharsetUtil.UTF_8));
            }
        }
    }

    private void consumerService(JSONObject msg, ChannelHandlerContext ctx, String dequeName) {

        LinkedBlockingDeque<String> linkedBlockingDeque = concurrentHashMap.get(dequeName);
        if (linkedBlockingDeque == null) {
            return;
        }
        // 从队列中取出该消息 响应给消费者
        String poll = linkedBlockingDeque.poll();
        if (StringUtils.isEmpty(poll)) {
            return;
        }

        // 响应内容:
        ctx.writeAndFlush(Unpooled.copiedBuffer(poll, CharsetUtil.UTF_8));

    }

    private void producerService(JSONObject msg, String dequeName) {

        // 消息内容
        String data = msg.getString("data");
        if (StringUtils.isEmpty(data)) {
            return;
        }
        // 从hashMap中找到该队列
        LinkedBlockingDeque<String> linkedBlockingDeque = concurrentHashMap.get(dequeName);
        if (linkedBlockingDeque == null) {
            linkedBlockingDeque = new LinkedBlockingDeque<String>();
            concurrentHashMap.put(dequeName, linkedBlockingDeque);
        }
        // 将该消息放入到该队列缓存起来
        linkedBlockingDeque.offer(data);
    }
}
