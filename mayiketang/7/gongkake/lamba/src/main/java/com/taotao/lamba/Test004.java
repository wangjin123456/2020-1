package com.taotao.lamba;

/**
 *@author tom
 *Date  2020/6/9 0009 7:51
 *
 */
public class Test004 {
    public static void main(String[] args) {
        //1,c采用匿名内部类形式
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"我是子线程");
            }
        }).start();
        //2使用lamba创建线程
        new Thread(()->   System.out.println(Thread.currentThread().getName()+"我是子线程1")).start();

    }
}
