package com.taotao.mybatis.util;

import lombok.extern.slf4j.Slf4j;
import redis.clients.jedis.Client;
import redis.clients.jedis.JedisPubSub;

/**
 * @author tom
 * @date 2020/4/6 0006 16:11
 */
@Slf4j
public class RedisMsgSublistener extends JedisPubSub {
    //取得订阅的消息后处理
    @Override
    public void onMessage(String channel, String message){
          log.info(channel+"="+message);
    }

    public RedisMsgSublistener() {
        super();
    }
//取得按表达式的方式订阅的消息后的处理
    @Override
    public void onPMessage(String pattern, String channel, String message) {
       log.info(pattern + "{}" + channel,message);
    }
 //初始化订阅时候的处理
    @Override
    public void onSubscribe(String channel, int subscribedChannels) {
       log.info(channel+"="+subscribedChannels);
    }
     //取消订阅时候的处理
    @Override
    public void onUnsubscribe(String channel, int subscribedChannels) {
        log.info(channel+"{}" + subscribedChannels);
    }

    @Override
    public void onPUnsubscribe(String pattern, int subscribedChannels) {
      log.info(pattern+"{}"+ subscribedChannels);
    }

    @Override
    public void onPSubscribe(String pattern, int subscribedChannels) {
        super.onPSubscribe(pattern, subscribedChannels);
    }

    @Override
    public void onPong(String pattern) {
        super.onPong(pattern);
    }

    @Override
    public void unsubscribe() {
        super.unsubscribe();
    }

    @Override
    public void unsubscribe(String... channels) {
        super.unsubscribe(channels);
    }

    @Override
    public void subscribe(String... channels) {
        super.subscribe(channels);
    }

    @Override
    public void psubscribe(String... patterns) {
        super.psubscribe(patterns);
    }

    @Override
    public void punsubscribe() {
        super.punsubscribe();
    }

    @Override
    public void punsubscribe(String... patterns) {
        super.punsubscribe(patterns);
    }

    @Override
    public void ping() {
        super.ping();
    }

    @Override
    public boolean isSubscribed() {
        return super.isSubscribed();
    }

    @Override
    public void proceedWithPatterns(Client client, String... patterns) {
        super.proceedWithPatterns(client, patterns);
    }

    @Override
    public void proceed(Client client, String... channels) {
        super.proceed(client, channels);
    }

    @Override
    public int getSubscribedChannels() {
        return super.getSubscribedChannels();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
