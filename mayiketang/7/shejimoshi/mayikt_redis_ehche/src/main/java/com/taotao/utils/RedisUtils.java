package com.taotao.utils;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @version V1.0
 * @description: redis工具类
 * @author: 97后互联网架构师-余胜军
 * @contact: QQ644064779、微信yushengjun644 www.mayikt.com
 * @date: 2019年1月3日 下午3:03:17
 * @Copyright 该项目“基于SpringCloud2.x构建微服务电商项目”由每特教育|蚂蚁课堂版权所有，未经过允许的情况下，
 * 私自分享视频和源码属于违法行为。
 */
@Component
public class RedisUtils {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    // 如果key存在的话返回fasle 不存在的话返回true
    public Boolean setNx(String key, String value, Long timeout) {
        Boolean setIfAbsent = stringRedisTemplate.opsForValue().setIfAbsent(key, value);
        if (timeout != null) {
            stringRedisTemplate.expire(key, timeout, TimeUnit.SECONDS);
        }
        return setIfAbsent;
    }

    /**
     * 存放string类型
     *
     * @param key     key
     * @param data    数据
     * @param timeout 超时间
     */
    public void setString(String key, String data, Long timeout) {
        stringRedisTemplate.opsForValue().set(key, data);
        if (timeout != null) {
            stringRedisTemplate.expire(key, timeout, TimeUnit.SECONDS);
        }
    }

    /**
     * 存放string类型
     *
     * @param key  key
     * @param data 数据
     */
    public void setString(String key, String data) {
        setString(key, data, null);
    }

    /**
     * 根据key查询string类型
     *
     * @param key
     * @return
     */
    public String getString(String key) {
        String value = stringRedisTemplate.opsForValue().get(key);
        return value;
    }

    public <T> T getEntity(String key, Class<T> t) {
        String json = getString(key);
        return JSONObject.parseObject(json, t);
    }

    public void putEntity(String key, Object object) {
        String json = JSONObject.toJSONString(object);
        setString(key, json);
    }

    /**
     * 根据对应的key删除key
     *
     * @param key
     */
    public boolean delKey(String key) {
        return stringRedisTemplate.delete(key);
    }


    public void setList(String key, List<String> listToken) {
        stringRedisTemplate.opsForList().leftPushAll(key, listToken);
    }

    public StringRedisTemplate getStringRedisTemplate() {
        return stringRedisTemplate;
    }
}
