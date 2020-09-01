package com.taotao.decorate.impl;

import com.taotao.decorate.ComponentCache;
import com.taotao.entity.UserEntity;
import com.taotao.mapper.UserMapper;
import com.taotao.utils.JvmMapCacheUtils;
import com.taotao.utils.RedisUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *@author tom
 *Date  2020/5/26 0026 9:11
 *
 */
@Component
public class JvmComponentCache  implements ComponentCache {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisUtils redisUtils;
    @Override
    public <T> T getCacheEntity(String key,Class<T> t, ProceedingJoinPoint proceedingJoinPoint) {
        //一级和耳机缓存
        //方法名称+参数名称+参数内容

        //先查询我们的一级缓存（Jvm配置）
        UserEntity jvmUser= JvmMapCacheUtils.getEntity(key,UserEntity.class);
        if(jvmUser !=null){
            //将缓存数据放入到缓存
            return (T) jvmUser;
        }
      /*  //查询db直接通过aop
        UserEntity dbUser=userMapper.findByUser(1);
        if(dbUser ==null){
            return  null;
        }*/
        //数据库db有的情况下将该内容缓存到当前的jvm中
        //JvmMapCacheUtils.putEntity(key,dbUser);
      //  return (T) dbUser;
        //查询我们的db，通过aop直接获取我们的目标对象方法
        try {
            Object resultDb=proceedingJoinPoint.proceed();
            //数据库db有的情况下将该内容缓存到当前的jvm里
            JvmMapCacheUtils.putEntity(key,resultDb);
            return  (T)resultDb;
        }catch (Throwable throwable){
            throwable.printStackTrace();
            return  null;
        }
    }


}
