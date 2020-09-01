package com.taotao.metithread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *@author tom
 *Date  2020/7/24 0024 22:31
 *
 */
public class Test19 {
    private static Lock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {

      Thread thread=new Thread(()->lock.lock());
      thread.start();
      thread.join();
      lock.unlock();

      /*  Thread t1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "获取锁");
            lock.lock();
            try {
                Thread.sleep(3000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "执行同步代码块");
        }, "t1");
        //t1线程获取锁
        t1.start();
        t1.join();
        Thread t2 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + ",获取锁");
            lock.lock();
            System.out.println(Thread.currentThread().getName() + "执行同步代码块");
        }, "t2");
        t2.start();
        t2.join();


        Thread t3 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "," + "t3./.....");
            lock.lock();
        }, "t3");
        t3.start();
        t3.join();


*/
    }
}
