package com.taotao.service;


import com.taotao.aop.ExtMeiteCache;
import com.taotao.decorate.MayiktCache;
import com.taotao.decorate.ext.RedisDecorate;
import com.taotao.entity.UserEntity;
import com.taotao.mapper.UserMapper;
import com.taotao.utils.JvmMapCacheUtils;
import com.taotao.utils.RedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName MemberService
 * @Author 蚂蚁课堂余胜军 QQ644064779 www.mayikt.com
 * @Version V1.0
 **/
@RestController
@Slf4j

public class MemberService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisDecorate redisDecorate;
    @Autowired
    private MayiktCache mayiktCache;
  /*  @RequestMapping("/getUser")
    public UserEntity getUser(Integer userId) {
        //一级和耳机缓存
        //方法名称+参数名称+参数内容
        String key="getUser(Integer)"+userId;

        //先查询二级缓存
        UserEntity redisUser=redisUtils.getEntity(key,UserEntity.class);
        if(redisUser !=null){
            return  redisUser;
        }
        //先查询我们的一级缓存（Jvm配置）
        UserEntity jvmUser= JvmMapCacheUtils.getEntity(key,UserEntity.class);
           if(jvmUser !=null){
               //将缓存数据放入到缓存
               redisUtils.putEntity(key,jvmUser);
               return jvmUser;
           }
           //查询db
        UserEntity dbUser=userMapper.findByUser(userId);
           if(dbUser ==null){
               return  null;
           }
        //数据库db有的情况下将该内容缓存到当前的jvm中
        JvmMapCacheUtils.putEntity(key,dbUser);
        return dbUser;
    }*/


/*
  @RequestMapping("/getUser")
  public UserEntity getUser(Integer userId) {
      String key="getUser(Integer)"+userId;
      return  mayiktCache.getCacheEntity(key);
  }*/


   @ExtMeiteCache
    @RequestMapping("/getUser")
    public UserEntity getUser(Integer userId) {
        return  userMapper.findByUser(userId);
    }
}
