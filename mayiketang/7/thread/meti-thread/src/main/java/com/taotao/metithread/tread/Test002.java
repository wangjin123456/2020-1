package com.taotao.metithread.tread;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 *@author tom
 *Date  2020/6/7 0007 21:27
 *
 */
public class Test002 {
    public static void main(String[] args) {
        BlockingDeque blockingDeque=new LinkedBlockingDeque();
        blockingDeque.offer("mayikt");
        blockingDeque.offer("meite");
        blockingDeque.offer("xiaouyu");
        System.out.println(blockingDeque.poll());
        System.out.println(blockingDeque.poll());
        System.out.println(blockingDeque.poll());
    }
}
