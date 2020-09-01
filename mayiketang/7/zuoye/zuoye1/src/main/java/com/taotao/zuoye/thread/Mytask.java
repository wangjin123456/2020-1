package com.taotao.zuoye.thread;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 *@author tom
 *Date  2020/7/17 0017 8:58
 *读写锁，读读共享，写写互斥
 */
public class Mytask {

    ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void read() {
        lock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + ",正在开始读取");
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + "，读取结束");

        } catch (Exception e) {
            e.getCause();
        }
        lock.readLock().unlock();
    }

    /**
     * 写写互斥
     */
    public void write() {
        lock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + ",正在开始写入");
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + ",写入结束");

        } catch (Exception e) {

        }
        lock.writeLock().unlock();
    }

    public static void main(String[] args) {
        Mytask mytask = new Mytask();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                mytask.read();

            }).start();
            new Thread(() -> {
                mytask.write();
            }).start();
        }
    }
}
