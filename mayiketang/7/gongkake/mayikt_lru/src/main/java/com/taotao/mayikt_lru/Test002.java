package com.taotao.mayikt_lru;

import java.util.LinkedHashMap;

/**
 *@author tom
 *Date  2020/6/15 0015 21:58
 *
 */
public class Test002 {
    public static void main(String[] args) {
        LinkedHashMap<String,String>linkedHashMap=new LinkedHashMap<String,String>(16,0.75f,true);

        linkedHashMap.put("a","a");
        linkedHashMap.put("b","b");
        linkedHashMap.put("c","c");
        linkedHashMap.get("a");
        linkedHashMap.get("b");
        linkedHashMap.forEach((k,v)->{
            System.out.println("key:"+k);
        });
    }
}
