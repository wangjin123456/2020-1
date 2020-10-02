package com.taotao.hashmap001;

import java.util.HashMap;

/**
 *@author tom
 *Date  2020/9/24 0024 8:09
 *
 */
public class Test11 {
    public static void main(String[] args) {
        HashMap<Object,String> hashmap=new HashMap<>();
        for (int i = 0; i < 12; i++) {
            hashmap.put(i,i+"");
        }
        hashmap.forEach((k,v)->{
            hashmap.put(13,13+"");
            System.out.println(k+","+v);
        });
    }
}
