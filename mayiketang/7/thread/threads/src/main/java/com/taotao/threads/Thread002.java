package com.taotao.threads;

/**
 *@author tom
 *Date  2020/6/23 0023 8:59
 *
 */
public class Thread002 implements Runnable {
    @Override
    public void run() {
        System.out.println("我是子线程："+Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        System.out.println("我是主线程："+Thread.currentThread().getName());
        new Thread(new Thread002()).start();
    }
}
