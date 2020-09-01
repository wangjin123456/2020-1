package com.taotao.zuoye.thread;

/**
 *@author tom
 *Date  2020/7/14 0014 22:58
 *
 */
public class Thread001 extends Thread {

    @Override
    public void run() {
        System.out.println("我是子线程：" + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        System.out.println("我是主线程：" + Thread.currentThread().getName());
        new Thread001().start();

    }
}
