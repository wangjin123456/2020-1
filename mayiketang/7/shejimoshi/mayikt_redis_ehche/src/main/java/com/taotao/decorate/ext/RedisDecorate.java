package com.taotao.decorate.ext;

import com.taotao.decorate.AbstractDecorate;
import com.taotao.decorate.impl.JvmComponentCache;
import com.taotao.entity.UserEntity;
import com.taotao.utils.JvmMapCacheUtils;
import com.taotao.utils.RedisUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *@author tom
 *Date  2020/5/26 0026 9:21
 *
 */
@Component
public class RedisDecorate  extends  JvmComponentCache implements AbstractDecorate {
    @Autowired
    private RedisUtils redisUtils;
    @Autowired
    private JvmComponentCache jvmComponentCache;
    @Override
    public <T> T getCacheEntity(String key,Class<T> t, ProceedingJoinPoint proceedingJoinPoint) {
        //先查询二级缓存
        T redisUser=redisUtils.getEntity(key,t);
        if(redisUser !=null){
            return (T) redisUser;
        }
        //先查询我们的一级缓存（Jvm配置）
        T jvmUser= super.getCacheEntity(key,t,proceedingJoinPoint);
        if(jvmUser !=null){
            //将缓存数据放入到缓存
            redisUtils.putEntity(key,jvmUser);
            return (T) jvmUser;
        }

        return null;
    }
}
