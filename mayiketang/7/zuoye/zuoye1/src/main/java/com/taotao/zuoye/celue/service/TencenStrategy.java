package com.taotao.zuoye.celue.service;

/**
 *@author tom
 *Date  2020/7/14 0014 8:40
 *
 */
public class TencenStrategy implements MsgStrategy {
    @Override
    public String sendMsg() {
        System.out.println("调用腾讯云");
        return "腾讯云";
    }
}
