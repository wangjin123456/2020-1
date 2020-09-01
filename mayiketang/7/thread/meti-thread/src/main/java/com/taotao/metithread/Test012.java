package com.taotao.metithread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *@author tom
 *Date  2020/7/24 0024 8:22
 *不同的锁实现方式
 */
public class Test012 extends Thread {
    private static int count = 0;
    private static Object LockObject = new Object();
    private static Lock lock = new ReentrantLock(true);
    private static MeiMayiLock meiMayiLock = new MeiMayiLock();

    @Override
    public void run() {
        while (count < 1000) {
            create3();
        }
    }

    private synchronized void create() {
        try {
            Thread.sleep(300);
        } catch (Exception e) {

        }
        synchronized (LockObject) {
            System.out.println(Thread.currentThread().getName() + "," + count++);
        }
    }

    private void create2() {
        try {
            Thread.sleep(300);
        } catch (Exception e) {
            e.printStackTrace();
        }
        lock.lock();
        System.out.println(Thread.currentThread().getName()+","+count++);
        lock.unlock();
    }
    private  void create3(){
        try {
            Thread.sleep(300);
        }catch (Exception e){

        }
        meiMayiLock.lock();
        System.out.println(Thread.currentThread().getName()+","+count++);
        meiMayiLock.unlock();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 4; i++) {
            new Test012().start();
        }
    }

}
