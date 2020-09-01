package com.taotao.mayikt_lru;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 *@author tom
 *Date  2020/6/15 0015 21:49
 *
 */
public class Test001 {
    public static void main(String[] args) {
      /*  HashMap<String,String> hashMap =new HashMap<>();
        for (int i = 0; i <30 ; i++) {
            hashMap.put(i+"",i+"");

        }
        hashMap.forEach((k,v)-> System.out.println(k+""+v+""));*/
        LinkedHashMap<String,String> linkedHashMap=new LinkedHashMap<>();
        for (int i = 0; i <20 ; i++) {
            linkedHashMap.put(i+"",i+"");
        }
        linkedHashMap.forEach((k,v)->{
            System.out.println(k+"  "+v);
        });


    }
}
