package com.taotao.metithread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *@author tom
 *Date  2020/7/29 0029 8:03
 *创建线程池
 */
public class Test040 {
    public static void main(String[] args) {
        //底层只会创建2个线程复用
        //可以定长线程池
        ExecutorService executorService= Executors.newFixedThreadPool(2);

        for (int i = 0; i <10 ; i++) {
            int fini=i;
            executorService.execute(()->
                    System.out.println(Thread.currentThread().getName()+":"+fini));
        }


    }


}
