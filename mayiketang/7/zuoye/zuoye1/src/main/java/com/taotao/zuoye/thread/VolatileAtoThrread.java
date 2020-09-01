package com.taotao.zuoye.thread;

import java.util.ArrayList;

/**
 *@author tom
 *Date  2020/7/18 0018 9:44
 *volatile 不能保证原子性
 */
public class VolatileAtoThrread extends Thread {
    private static volatile int count;

    public static void create() {
        count++;
    }

    public static void main(String[] args) {
        ArrayList<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {

            Thread tempThread = new Thread(() -> {
                for (int j = 0; j < 10; j++) {
                    create();
                }
            });
            threads.add(tempThread);
            tempThread.start();
        }
        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        System.out.println(count);
    }

}
