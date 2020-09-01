package com.taotao.zuoye.thread;

/**
 *@author tom
 *Date  2020/7/15 0015 22:29
 * 双重检验锁
 */
public class Thread006 implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ", 我是子线程");
        a();
    }

    private synchronized void a() {
        System.out.println(Thread.currentThread().getName() + " ,我是方法A");
        b();
    }

    private synchronized void b() {
        System.out.println(Thread.currentThread().getName() + ",我是方法b");

    }

    public static void main(String[] args) {
        new Thread(new Thread006()).start();
        System.out.println(Thread.currentThread().getName() + ",主线程");
    }
}
