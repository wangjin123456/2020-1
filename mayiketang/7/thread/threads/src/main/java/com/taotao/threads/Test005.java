package com.taotao.threads;

/**
 *@author tom
 *Date  2020/8/3 0003 6:59
 *
 */
public class Test005 {
    private static ThreadLocal<String> threadLocalMap = new ThreadLocal<String>();
    private static ThreadLocal<String> threadLocalMap1 = new ThreadLocal<String>();

    public static void main(String[] args) {
        threadLocalMap1.set("55");
        threadLocalMap.set("99");
        threadLocalMap.remove();;
        threadLocalMap=null;
        System.gc();
        Thread thread=Thread.currentThread();

        threadLocalMap.get();
    }
}
