package com.taotao.metithread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *@author tom
 *Date  2020/7/26 0026 8:16
 *condition 用法
 */
public class Test031 {
    private  static Lock lock=new ReentrantLock();
    private  static Condition condition=lock.newCondition();

    public static void main(String[] args) {

        new Thread(()->{
            System.out.println("1");
            try {
                lock.lock();
                //当前子线程释放锁，同时变为阻塞状态
                condition.await();
            }catch (Exception e){

            }
            System.out.println(2);
            lock.unlock();
        },"t1").start();
        try {
            Thread.sleep(3000);
        }catch (Exception e){

        }
        System.out.println("3");
        lock.lock();
        //主线程唤醒t1
        condition.signal();
        lock.unlock();
    }
}
