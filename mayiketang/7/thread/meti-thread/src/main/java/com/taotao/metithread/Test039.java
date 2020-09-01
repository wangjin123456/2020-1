package com.taotao.metithread;

import java.util.concurrent.Semaphore;

/**
 *@author tom
 *Date  2020/7/28 0028 8:55
 *Sempore() 信号量限流
 */
public class Test039 {
    public static void main(String[] args) throws InterruptedException {
        //设置aqs状态为5 只能限制5个线程执行代码
       Semaphore semaphore= new Semaphore(5);
        for (int i = 0; i <= 20; i++) {
            new Thread(()->{

                try {
                    //aqs状态减1如果状态为0的情况下会编外阻塞
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"获取门票：");
                    //aqs状态加1同时唤醒阻塞的状态
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();

        }
    }
}
