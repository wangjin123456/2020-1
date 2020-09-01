package com.taotao.metithread;

import java.util.concurrent.CountDownLatch;

/**
 *@author tom
 *Date  2020/7/28 0028 7:43
 *手写countdownlatch
 */
public class Test36 {
    private static Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
//        new Thread(()->{
//            System.out.println(1);
//            synchronized (lock){
//                try{
//                    //当前线程释放锁，当前线程变为阻塞
//                    lock.wait();
//                }catch (Exception e){
//
//                }
//                System.out.println(2);
//            }
//        }).start();
//        Thread.sleep(3000);
//        System.out.println(3);
//        synchronized (lock){
//            try {
//             lock.notify();
//            }catch (Exception e){
//
//            }
//        }


        //将aqs状态设置为2
        CountDownLatch countDownLatch = new CountDownLatch(2);
        new Thread(() -> {
            System.out.println(1);

                try {
                    //当前线程释放锁，当前线程变为阻塞
                    countDownLatch.await();
                } catch (Exception e) {

                }
                System.out.println(2);

        }).start();
        Thread.sleep(3000);
        System.out.println(3);
        countDownLatch.countDown();
        countDownLatch.countDown();
        //aqs状态为-1只有aqs状态为0的时候才会唤醒子线程
    }


}
