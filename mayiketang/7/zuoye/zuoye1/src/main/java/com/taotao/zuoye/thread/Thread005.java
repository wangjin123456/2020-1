package com.taotao.zuoye.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *@author tom
 *Date  2020/7/15 0015 23:15
 *lock 锁的基本用法， 重入锁 ReentrantLock
 */
public class Thread005 implements Runnable {
    private static int count = 100;
    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while (count > 0) {
            ticket();
        }
    }

    private void ticket() {
        try {
            Thread.sleep(30);
        } catch (Exception e) {

        }
        try {
            lock.lock();
            if (count > 0) {
                System.out.println(Thread.currentThread().getName() + ",正在出售：" + (100 - count + 1));
                count--;
            }
        } catch (Exception e) {
            e.getCause();
        } finally {
            lock.unlock();
        }


    }

    public static void main(String[] args) {
        Thread005 thread005 = new Thread005();
        new Thread(thread005, "窗口1").start();
        new Thread(thread005, "窗口2").start();
        ;
    }
}
