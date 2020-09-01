package com.taotao.metithread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *@author tom
 *Date  2020/7/24 0024 9:26
 *
 */
public class Test21 {
    private static Lock lock = new ReentrantLock(false);

    public static void main(String[] args) throws InterruptedException {
   /*     System.out.println(1);
        Thread t1 = new Thread(() -> {
            lock.lock();
        });
        t1.start();
        t1.join();
        System.out.println(2);*/
        lock.lock();
        lock.lock();
    }

    public static void a() {
        //多个线程抢一把锁，只有一个线程可以抢到锁，其他的进入阻塞
        lock.lock();
        ;//获取锁
        try {
            System.out.println("我是A方法");
            lock.unlock();//释放锁
        } catch (Exception e) {

        }

    }

    public static void b() {
        lock.lock();
        System.out.println("我是b方法");
        lock.unlock();
    }

}
