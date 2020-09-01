package com.taotao.metithread;

import java.util.concurrent.ConcurrentLinkedDeque;

/**
 *@author tom
 *Date  2020/7/24 0024 7:54
 *
 */
public class Test16 {
    public static void main(String[] args) {
        ConcurrentLinkedDeque waitThread=new ConcurrentLinkedDeque<>();
        waitThread.add("mayikt");
        waitThread.add("meite");
        waitThread.add("xiaowei");
//队列遵循先进先出
        System.out.println(waitThread.peek());
        System.out.println(waitThread.size());
    }
}
