package hello.spring.cloud.alibaba.rocketmq.provider.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

/**
 * 消息生产者服务
 * @autor tom
 * @date 2020/3/23 0023 10:19
 */
@Service
public class ProviderService {
    @Autowired
    private MessageChannel output;
    public void send(String message){
        //撒送消息
        output.send(MessageBuilder.withPayload(message).build());
    }
}
