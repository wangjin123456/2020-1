package com.taotao.mybatis.util;

import com.mysql.jdbc.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPubSub;
import redis.clients.jedis.commands.MultiKeyJedisClusterCommands;

/**
 * @author tom
 * @date 2020/4/6 0006 14:34
 */
@Slf4j
public class RedisMQ {
    private  static  final String TOPIC="TOPIC";
    private  final JedisPool jedisPool;


    public RedisMQ(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }

    /**
     * 发布消息
     * @param topic
     * @param message
     */
    public  void publish(String topic,String message){
        Jedis jedis=null;
        if(Strings.isBlank(topic)){
            topic=TOPIC;
        }
        try {
            jedis=jedisPool.getResource();
            jedis.publish(topic,message);
            log.info("发送消息：topic：{}{}"+ topic+ message);
        }finally {
            if(null !=jedis){
                jedis.close();
            }
        }
    }

    /**
     * 订阅消息
     * @param topic
     * @param jedisPubSub
     */
    public  void subscribe(String topic, JedisPubSub jedisPubSub){
         Jedis jedis=null;
         if(Strings.isBlank(topic)){
             topic=TOPIC;
         }
         try {
             jedis=jedisPool.getResource();

             log.info("取出消息队列的消息： topic:{}{}"+topic+jedisPubSub);
             jedis.subscribe(jedisPubSub,topic);

         }finally {
             jedis.close();
         }
    }

    public static void main(String[] args) {
        //默认连接本地redis
        JedisPool jedisPool=new JedisPool();
        RedisMQ publish= new RedisMQ(jedisPool);

        new Thread(new Runnable() {
            @Override
            public void run() {
                publish.subscribe("PID",new MyjedisPubSub());
            }
        }).start();
        for (int i = 0; i <100 ; i++) {
            publish.publish("PID","message"+i);
        }
    }

    public  static  class MyjedisPubSub extends JedisPubSub{
        @Override
        public void onMessage(String channel, String message) {

            System.out.println("-------channel is "+channel+" message is "+message);


           // super.onMessage(channel, message);
        }
    }
}
