package com.taotao.zuoye.thread;

/**
 *@author tom
 *Date  2020/7/15 0015 8:41
 *
 */
public class TicketThread implements Runnable {
    private int count = 100;
    private static String Lock = "lock";

    @Override
    public void run() {
        while (count > 0) {
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                e.getCause();
            }
            ticket();
        }
    }

    private void ticket() {
        synchronized (this) {
            if (count > 0) {
                System.out.println(Thread.currentThread().getName() + ",正在开始售票："
                        + (100 - count + 1));
                count--;
            }
        }
    }

    public static void main(String[] args) {
        TicketThread ticketThread = new TicketThread();
        Thread thread1 = new Thread(ticketThread, "窗口1");
        new Thread(ticketThread, "窗口2").start();
        thread1.start();
    }

}
