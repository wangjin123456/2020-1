package com.taotao.utils;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName JvmMapCacheUtils
 * @Author 蚂蚁课堂余胜军 QQ644064779 www.mayikt.com
 * @Version V1.0
 **/
public class JvmMapCacheUtils {
    //缓存容器
   private  static  Map<String,String> caches=new ConcurrentHashMap<>();

   //获取缓存
   public static <T> T getEntity(String key, Class<T> t){
       //缓存存储对象的情况
       String  json=caches.get(key);
       return JSONObject.parseObject(json,t);
   }
   //获取缓存
   public static  void putEntity(String key,Object o){
       String json=JSONObject.toJSONString(o);
       caches.put(key,json);
   }
}
