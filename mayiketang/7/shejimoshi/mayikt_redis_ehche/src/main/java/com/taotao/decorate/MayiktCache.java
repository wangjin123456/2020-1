package com.taotao.decorate;

import com.taotao.decorate.ext.RedisDecorate;
import com.taotao.entity.UserEntity;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *@author tom
 *Date  2020/5/26 0026 9:33
 *
 */
@Component
public class MayiktCache {
    @Autowired
    private RedisDecorate redisDecorate;
    public <T> T getCacheEntity(String key,Class<T> t, ProceedingJoinPoint joinPoint) {
         return  redisDecorate.getCacheEntity(key,t,joinPoint);
    }
}
