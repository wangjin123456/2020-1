package com.taotao.producer.stream;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.SubscribableChannel;


/**
 *@author tom
 *Date  2020/5/19 0019 7:37
 *
 */
public interface SendMessageInterface {
    //1.创建发送消息的通道

    @Output("my_stream_channel")
    SubscribableChannel sendMsg();
}
