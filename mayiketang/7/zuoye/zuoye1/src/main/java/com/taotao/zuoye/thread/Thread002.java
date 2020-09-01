package com.taotao.zuoye.thread;

/**
 *@author tom
 *Date  2020/7/14 0014 23:07
 *
 */
public class Thread002 implements Runnable {
    @Override
    public void run() {
        System.out.println("我是子线程：" + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        new Thread(new Thread002()).start();
        System.out.println("我是主线程");

    }
}
