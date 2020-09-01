package com.taotao.lamba;

import com.taotao.lamba.service.MessageInterface;
import com.taotao.lamba.service.MessageInterface2;

/**
 *@author tom
 *Date  2020/6/4 0004 9:39
 *
 */
public class Test07 {
    public static void main(String[] args) {
        MessageInterface messageInterface=() ->{
            System.out.println();
            return  new MessageEntity();
        };
        //构造函数，无参
        MessageInterface messageInterface2=MessageEntity::new;
        MessageInterface2 messageInterface3=MessageEntity::new;
    }
}
