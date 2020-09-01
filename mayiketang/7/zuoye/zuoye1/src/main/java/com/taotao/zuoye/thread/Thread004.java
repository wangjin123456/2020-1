package com.taotao.zuoye.thread;

/**
 *@author tom
 *Date  2020/7/15 0015 22:45
 *
 */
public class Thread004 implements Runnable {
    private static int count = 100;
    private Boolean flag = true;
    private Object object = new Object();

    @Override
    public void run() {
        if (flag) {
            while (count > 0) {
                synchronized (object) {
                    try {
                        Thread.sleep(10);
                    } catch (Exception e) {
                        e.getCause();
                    }
                    ticket();
                }
            }

        } else {
            while (count > 0) {
                ticket();
            }
        }


    }

    private synchronized void ticket() {
        synchronized (object) {
            try {

                Thread.sleep(10);
            } catch (Exception e) {
                e.getCause();
            }
            if (count > 0) {
                System.out.println(Thread.currentThread().getName() + ",正在开始出售：" + (100 - count + 1));
                count--;
            }

        }


    }

    public static void main(String[] args) {
        Thread004 thread004 = new Thread004();
        new Thread(thread004, "窗口1").start();
        try {
            Thread.sleep(40);
            thread004.flag = false;
        } catch (Exception e) {
            e.getCause();
        }
        new Thread(thread004, "窗口2").start();

    }
}
