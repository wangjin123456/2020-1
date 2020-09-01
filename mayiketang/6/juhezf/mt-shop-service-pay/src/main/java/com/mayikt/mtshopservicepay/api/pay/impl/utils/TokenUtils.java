package com.mayikt.mtshopservicepay.api.pay.impl.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 *@author tom
 *Date  2020/4/21 0021 10:04
 *
 */
@Component
public class TokenUtils {
    @Autowired
    private  RedisUtil redisUtil;
    public  String createToken(String prefix,String value){
        return  createToken(prefix,value,null);
    }
    public  String createToken(String prefix,String value,Long timeOut){
        //生成我们的令牌
        String token=prefix+"-"+ UUID.randomUUID().toString().replace("-","");
        //2,将该token存入到Redis中
        redisUtil.setString(token,value,timeOut);
        return token;
    }
    public  String getTokenValue(String token){
        return  redisUtil.getString(token);
    }
    public boolean delToken(String token){
        return redisUtil.delKey(token);
    }


}
