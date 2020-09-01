package com.taotao.jvm1.day08;

/**
 *@author tom
 *Date  2020/8/25 0025 10:07
 *gc日志回收 设置新生代和老年代的空间比
 * -XX:+PrintGCDetails -verbose:gc -XX:SurvivorRatio=2 -XX:NewRatio=1
 */
public class Test02 {

    public static void main(String[] args) {
        // -Xms20m -Xmx20m  -XX:+PrintGCDetails -verbose:gc
        //-Xms20m -Xmx20m -XX:+PrintGCDetails -verbose:gc
        System.out.println("my");
    }

}
