package com.taotao.lamba;

/**
 *@author tom
 *Date  2020/6/4 0004 9:40
 *
 */
public class MessageEntity {
    private  String messageId;
    private  String messageContext;

    public MessageEntity() {
    }

    public MessageEntity(String messageId, String messageContext) {
        this.messageId = messageId;
        this.messageContext = messageContext;
    }
}
