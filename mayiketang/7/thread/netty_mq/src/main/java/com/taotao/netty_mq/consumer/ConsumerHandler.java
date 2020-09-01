package com.taotao.netty_mq.consumer;

import com.alibaba.fastjson.JSONObject;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

/**
 * @ClassName ProducerHandler
 * @Author 蚂蚁课堂余胜军 QQ644064779 www.mayikt.com
 * @Version V1.0
 **/
public class ConsumerHandler extends SimpleChannelInboundHandler<ByteBuf> {


    /**
     * 活跃通道可以发送消息
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
//        // 发送数据
        JSONObject send = new JSONObject();
        send.put("type", "consumer");
        send.put("dequeName", "mayiktMember");
        ctx.writeAndFlush(Unpooled.copiedBuffer(send.toJSONString(), CharsetUtil.UTF_8));
    }

    /**
     * 读取消息
     *
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {
        System.out.println("resp：" + msg.toString(CharsetUtil.UTF_8));
    }
}