package com.taotao.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *@author tom
 *Date  2020/6/23 0023 9:22
 *
 */
public class Thread003 {
    public static void main(String[] args) {
        ExecutorService executorService= Executors.newCachedThreadPool();
        executorService.execute(() -> System.out.println(Thread.currentThread().getName()+"创建线程成功"));
    }
}
