package com.taotao.threads.days08;

/**
 *@author tom
 *Date  2020/8/1 0001 8:08
 *ThreadLocal  get/set方法
 */
public class Test001 {
    private static  ThreadLocal threadLocal=new ThreadLocal<String>();

    public static void main(String[] args) throws InterruptedException {
        Thread thread=new Thread(()->{
            threadLocal.set("mayikt");
            System.out.println(Thread.currentThread().getName()+","+threadLocal.get());
        });
        thread.start();
       thread.join();

    }
}
