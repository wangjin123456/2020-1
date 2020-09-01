package com.taotao.metithread;

import java.util.concurrent.locks.ReentrantLock;

/**
 *@author tom
 *Date  2020/7/23 0023 7:21
 *锁的消除
 */
public class Test008 {
    ReentrantLock lock=new ReentrantLock();
    public static void main(String[] args) {
        addString("1","2","3");
    }

    private static String addString(String s1,String s2,String s3) {
    return new StringBuffer().append(s1).append(s2).append(s3).toString();
    }
}
