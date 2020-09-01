package com.taotao.zuoye.thread;

/**
 *@author tom
 *Date  2020/7/18 0018 9:12
 *volatitle  可见性
 */
public class Mayikt extends Thread {
    private static volatile boolean Flag = true;

    @Override
    public void run() {
        while (Flag) {
            System.out.println("执行");
        }

    }

    public static void main(String[] args) throws InterruptedException {
        new Mayikt().start();
        Thread.sleep(1000);
        Flag = false;
    }
}
