package com.taotao.springbootcafka.sender;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

/**
 *@author tom
 *Date  2020/5/17 0017 22:01
 *
 */
@Component
public class KafkaSender {

    private static final Logger logger = LoggerFactory.getLogger(KafkaSender.class);
    @Autowired
    private KafkaTemplate kafkaTemplate;

    //自定义topic
    public static final String TOPIC_ONE="topic.one";

    public void send(Object obj){
        logger.info("准备发送消息为：{}",JSONObject.toJSONString(obj));
        //发送消息
        ListenableFuture<SendResult<String,Object>> future=kafkaTemplate.send(TOPIC_ONE,obj);
        future.addCallback(new ListenableFutureCallback<SendResult<String, Object>>() {
            @Override
            public void onFailure(Throwable throwable) {
                //发送失败的处理
                logger.info(TOPIC_ONE+" - 生产者 发送消息失败："+throwable.getMessage());
            }

            @Override
            public void onSuccess(SendResult<String, Object> stringObjectSendResult) {
                //成功的处理
                logger.info(TOPIC_ONE+" - 生产者 发送消息成功："+stringObjectSendResult.toString());
            }
        });


    }
}