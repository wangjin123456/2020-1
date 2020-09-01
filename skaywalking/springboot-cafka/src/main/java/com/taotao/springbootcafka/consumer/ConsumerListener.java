package com.taotao.springbootcafka.consumer;

import com.taotao.springbootcafka.sender.KafkaSender;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 *@author tom
 *Date  2020/5/17 0017 21:44
 *消费者监听
 */
@Component
@Slf4j
public class ConsumerListener {


    @KafkaListener(topics = KafkaSender.TOPIC_ONE,groupId = KafkaSender.TOPIC_ONE)
    public void topic_one(ConsumerRecord<?, ?> record, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic){

        Optional message=Optional.ofNullable(record.value());
        if (message.isPresent()){
            Object msg=message.get();
            log.info("被"+KafkaSender.TOPIC_ONE+"消费了： +++++++++++++++ Topic:" + topic+",Record:" + record+",Message:" + msg);
        }
    }
}
