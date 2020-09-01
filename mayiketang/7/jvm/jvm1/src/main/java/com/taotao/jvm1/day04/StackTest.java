package com.taotao.jvm1.day04;

/**
 *@author tom
 *Date  2020/8/12 0012 10:06
 *-Xss256k  java.lang.StackOverflowError 性能调优
 */

public class StackTest {
 private  static  int count;

    public static void main(String[] args) {
        mk01();
    }

    private static void mk01() {
        count++;
        System.out.println("count:"+count);
        mk01();
    }
}
