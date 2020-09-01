package com.taotao.threads;

/**
 *@author tom
 *Date  2020/6/23 0023 8:55
 *
 */
public class Thread001  extends  Thread{
    @Override
    public void run() {
        System.out.println("我是子线程"+Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        System.out.println("我是主线程："+Thread.currentThread().getName());
        //调用start
        new Thread001().start();
    }
}
