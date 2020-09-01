package com.taotao.mybatis.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;

/**
 * 序列化工具类
 * 使用FastJso 对要缓存的数据进行序列化存储与获取缓存中的反序列化
 * 使用fastJson 对数据进行序列化与反序列化，
 * @author tom
 * @date 2020/4/6 0006 10:52
 */
@Slf4j
public class SerializeUtil {
public  static  String serializeobject(Object obj){
    log.info("serialize object :"+obj);
    String jsonobj= JSON.toJSONString(obj);
    return  jsonobj;
}

    public  static JSONObject unserializeobject(String serobj){
    log.info("unserialize object:"+serobj);
    JSONObject jsonObject =JSON.parseObject(serobj);
    return  jsonObject;
    }
}
