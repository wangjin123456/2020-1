package com.taotao.hashmap001;

import java.util.HashMap;

/**
 *@author tom
 *Date  2020/9/22 0022 7:19
 *二进制位移运算
 */
public class Test0010 {
    public static void main(String[] args) {
        //System.out.println(10>>2);//5
        HashMap hashMap=new HashMap();
        hashMap.put("1","1");
        String key="张三";
        System.out.println(key.hashCode());
        System.out.println(2&3);//与运算 相同为0 不相同为1
    }
    static  final int hash(Object key){
        int h;
        return  (key ==null)?0:(h=key.hashCode()) ^(h>>>16);
    }

}
