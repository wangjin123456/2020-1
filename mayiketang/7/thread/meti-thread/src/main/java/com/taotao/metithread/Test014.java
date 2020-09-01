package com.taotao.metithread;

/**
 *@author tom
 *Date  2020/7/23 0023 9:14
 *唤醒阻塞的线程
 */
public class Test014 {
    private static Object lock=new Object();
    public static void main(String[] args) {
        new Thread(()->{
            try {
                synchronized (lock){
                    System.out.println(1);
                    //释放锁，同时释放CPU执行权
                    lock.wait();
                    System.out.println(2);
                }
               // Thread.sleep(10000000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        try {
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(3);
        synchronized (lock){
            lock.notify();
            System.out.println(4);
        }

        System.out.println("主线程唤醒子线程");
    }
}
