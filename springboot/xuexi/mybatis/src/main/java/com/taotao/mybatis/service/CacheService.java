package com.taotao.mybatis.service;

import org.aopalliance.intercept.Joinpoint;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletRequest;

/**
 * 封装了关于缓存的get set containkey getkeyAop
 * @author tom
 * @date 2020/4/6 0006 11:05
 */
public interface CacheService {
    //获取jedis实例
    Jedis getResource() throws Exception;

    //设置key与 value
    void set(String key, String value, String nxxx, String expx, long time);

    //根据key获取value
    String get(String key);

    //判断是否存在key
    boolean containkey(String key);

    //是否jedis 实例资源
    void returnResource(Jedis jedis);

    //获取key
    String getkeyForAop(Joinpoint joinpoint, HttpServletRequest request);

}
