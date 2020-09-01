package com.taotao.metithread.tread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *@author tom
 *Date  2020/6/27 0027 7:33
 *lock 锁
 */
public class LockThread implements Runnable {
    private static int count = 200;
    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while (count>0){
            ticket();

        }

    }

    public void ticket() {
        try {
            Thread.sleep(300);
        } catch (Exception e) {

        }
        try {
            lock.lock();
            if (count > 0) {
                count--;
                System.out.println(Thread.currentThread().getName() + "正在出票第" + (20 - count + 1) + "张票");
            }

        } catch (Exception e) {
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        LockThread ticketThread = new LockThread();
        new Thread(ticketThread, "窗口1").start();
        new Thread(ticketThread, "窗口2").start();
    }
}
