package com.taotao.orderday105.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.support.atomic.RedisAtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *@author tom
 *Date  2020/6/6 0006 0:06
 *基于redis分布式id
 */
@RestController
public class OrderController {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 前缀，当前日期+5位自增id
     * @return
     */
    @RequestMapping("/order")
    public String order(String key) {
        String id=null;
        RedisAtomicLong redisAtomicLong = new RedisAtomicLong(key, redisTemplate.getConnectionFactory());
        //   redisAtomicLong.set(10);//开始值
             redisAtomicLong.addAndGet(2);//步长
      //  for (int i = 0; i < 100; i++) {
            long incrementandget = redisAtomicLong.incrementAndGet();
            id = prefix() + "-" + String.format("%1$05d", incrementandget);
            System.out.println("INSERT INTO `test`.`ordernumber`(`order-number`) VALUES("+ id+");");
       // }
        return id;
    }

    public static String prefix() {
        String temp_str = "";
        Date dt = new Date();
        //最后的aa上午或者下午 HH表示24小时 hh表示12小时
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        temp_str = sdf.format(dt);
        return temp_str;
    }
}
