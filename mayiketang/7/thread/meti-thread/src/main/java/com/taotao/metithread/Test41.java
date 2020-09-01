package com.taotao.metithread;

import java.util.concurrent.*;

/**
 *@author tom
 *Date  2020/7/29 0029 8:10
 *
 */
public class Test41 {
    public static void main(String[] args) {
        ExecutorService executorService= Executors.newFixedThreadPool(2);
        ExecutorService executorService1=Executors.newCachedThreadPool();
        Executors.newSingleThreadExecutor();
        Executors.newScheduledThreadPool(10);

        new ArrayBlockingQueue<>(2);
        new LinkedBlockingDeque<>();
    }

}
