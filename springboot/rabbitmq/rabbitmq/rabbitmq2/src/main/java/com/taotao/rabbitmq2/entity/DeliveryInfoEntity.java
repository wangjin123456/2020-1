package com.taotao.rabbitmq2.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @autor tom
 * @date 2020/3/3 0003  22:04
 */
@Data
public class DeliveryInfoEntity  implements Serializable {
    //发送消息的内容
    private  String msg;
    //对列名称
    private  String queueName;
    //生产者投递消息 true   消费者投递消息 false
    private boolean connType;

    public DeliveryInfoEntity(String msg, String queueName, boolean connType) {
        this.msg = msg;
        this.queueName = queueName;
        this.connType = connType;
    }

    public boolean isConnType() {
        return connType;
    }

    public DeliveryInfoEntity setConnType(boolean connType) {
        this.connType = connType;
        return this;
    }
}
