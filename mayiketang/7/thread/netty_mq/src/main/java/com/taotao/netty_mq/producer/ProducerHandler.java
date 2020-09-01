package com.taotao.netty_mq.producer;

import com.alibaba.fastjson.JSONObject;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

/**
 *@author tom
 *Date  2020/8/5 0005 23:26
 *
 */
public class ProducerHandler  extends SimpleChannelInboundHandler<ByteBuf> {

    /**
     * 活跃通道可以发送消息
     * @param channelHandlerContext
     * @param byteBuf
     * @throws Exception
     */
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) throws Exception {
        JSONObject send=new JSONObject();
        send.put("type","producer");
        send.put("dequeName","mayiktMember");
       JSONObject data=  new JSONObject();
       data.put("userId","123345");
       data.put("phone","33222");
        send.put("data",data);
        //发送消息
        channelHandlerContext.writeAndFlush(Unpooled.copiedBuffer(send.toString(), CharsetUtil.UTF_8));


    }
}
