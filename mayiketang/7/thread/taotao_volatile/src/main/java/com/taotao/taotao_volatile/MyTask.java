package com.taotao.taotao_volatile;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 *@author tom
 *Date  2020/7/10 0010 9:26
 *共享锁 读读共享，读写互斥，写写互斥
 */
public class MyTask {
    ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void readlock() {
        lock.readLock().lock();
        System.out.println(">>>" + Thread.currentThread().getName() + "正在读取锁开始");
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.getCause();
        }
        System.out.println(">>>" + Thread.currentThread().getName() + "正在读取锁结束");

        lock.readLock().unlock();
    }

    public void writelock() {
        lock.writeLock().lock();
        System.out.println(">>>" + Thread.currentThread().getName() + "正在写入锁开始");
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.getCause();
        }
        System.out.println(">>>" + Thread.currentThread().getName() + "正在写入锁结束");

        lock.writeLock().unlock();
    }

    public static void main(String[] args) {
        MyTask myTask=new MyTask();
        for (int i = 0; i < 10; i++) {
           new Thread(()->{
               myTask.readlock();
           }).start();
        }
        for (int i = 0; i <10 ; i++) {
            new Thread(()-> myTask.writelock()).start();
        }
    }
}
