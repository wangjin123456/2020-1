package com.taotao.metithread;

import java.util.concurrent.locks.LockSupport;

/**
 *@author tom
 *Date  2020/7/23 0023 9:20
 *
 */
public class Test015 {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            //当前线程释放cpu 变为阻塞状态
            System.out.println(
                    1
            );
            LockSupport.park();
            System.out.println(2);
        });
        thread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(3);
        //唤醒刚刚阻塞的线程
        LockSupport.unpark(thread);
        System.out.println("唤醒阻塞的线程");
    }
}
