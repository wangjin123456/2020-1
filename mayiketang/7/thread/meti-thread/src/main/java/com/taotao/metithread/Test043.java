package com.taotao.metithread;

import java.util.concurrent.locks.LockSupport;

/**
 *@author tom
 *Date  2020/7/31 0031 9:12
 *手写FutureTask()
 */
public class Test043 {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            System.out.println("让我们的子线程变为阻塞状态");
            LockSupport.park();
            System.out.println("唤醒我们的子线程");
        });
        t1.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LockSupport.unpark(t1);
    }

}
