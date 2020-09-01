package com.taotao.jvm1.day08;

import java.util.ArrayList;

/**
 *@author tom
 *Date  2020/8/25 0025 10:23
 *
 */
public class Test01 {
    // -Xms20m -Xmx20m  -XX:+PrintGCDetails -verbose:gc
    //-Xms20m -Xmx20m -XX:+PrintGCDetails -verbose:gc
    public static void main(String[] args) {
        ArrayList<Object> mt=new ArrayList<>();
        //在堆内存存放1m
        mt.add(new byte[15*1024*1024]);
    }
}
