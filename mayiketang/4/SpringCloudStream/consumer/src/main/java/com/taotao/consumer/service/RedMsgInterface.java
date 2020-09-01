package com.taotao.consumer.service;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 *@author tom
 *Date  2020/5/19 0019 8:26
 *
 */

public interface RedMsgInterface {
    @Input("my_stream_channel")
    SubscribableChannel redMsg();
}
