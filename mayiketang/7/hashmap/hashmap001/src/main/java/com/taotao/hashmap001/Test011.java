package com.taotao.hashmap001;

import java.util.HashMap;

/**
 *@author tom
 *Date  2020/9/25 0025 8:30
 *
 */
public class Test011 {
    public static void main(String[] args) {

        HashMap<Object,String>hashMap=new HashMap<>();
        for (int i = 0; i <10000 ; i++) {
            hashMap.put(i,i+"");
        }
    }
}
