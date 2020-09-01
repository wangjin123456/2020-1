package com.taotao.metithread.tread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 *@author tom
 *Date  2020/6/27 0027 7:51
 *ReentrantReadWriteLock 锁
 */
public class MyTask {
    private ReentrantReadWriteLock lock=new ReentrantReadWriteLock();
    public static void main(String[] args) {
          MyTask myTask=new MyTask();
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
               // myTask.read();
                myTask.write();
            }).start();
        }
        for (int i = 0; i <10 ; i++) {
            new Thread(()->{
                myTask.read();
            }).start();
        }
    }

    /**
     * 读读锁
     */
    public  void read(){
        lock.readLock().lock();
        System.out.println(Thread.currentThread().getName()+"，开始读取数据");
        try {
            Thread.sleep(1000);
        }catch (Exception e){
            e.getCause();
        }
        System.out.println(Thread.currentThread().getName()+",结束读取数据");
    lock.readLock().unlock();
    }

//如果多个线程同时写的话写写互斥
    public  void write(){
        lock.writeLock().lock();
        System.out.println(Thread.currentThread().getName()+"，开始写取数据");
        try {
            Thread.sleep(1000);
        }catch (Exception e){
            e.getCause();
        }
        System.out.println(Thread.currentThread().getName()+",结束写取数据");
        lock.writeLock().unlock();
    }
}
