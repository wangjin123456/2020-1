package com.taotao.zuoye.unity;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;

/**
 *@author tom
 *Date  2020/7/10 0010 22:13
 *
 */
public class JvmMapCahcheUtils {
    private static HashMap<String, String> cacheMap = new HashMap<String, String>();

    public static void putEntity(String key, Object object) {
        cacheMap.put(key, JSONObject.toJSONString(object));
    }


    public static <T> T getEntity(String key, Class<T> t) {
        String json = cacheMap.get(key);
        JSONObject jsonObject = JSONObject.parseObject(json);
        return JSONObject.parseObject(json, t);

    }

}
