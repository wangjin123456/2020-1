package com.taotao.threads.days08;

/**
 *@author tom
 *Date  2020/8/1 0001 8:36
 *
 */
public class Test002 {
    // private String context;

    public String getContext() {
        return threadLocal.get();
    }

    public void setContext(String context) {
        threadLocal.set(context);

    }

    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    private static Object lock = new Object();

    public static void main(String[] args) {
        Test002 test002 = new Test002();
        for (int i = 0; i < 500; i++) {
            int finalI = i;
            new Thread(() -> {
                // synchronized (lock){

                threadLocal.set(Thread.currentThread().getName() + "," + finalI);
                // test002.context=Thread.currentThread().getName()+","+ finalI;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(threadLocal.get());
                //}
            }, i + "").start();
        }
    }
}
