package com.taotao.metithread;

import org.openjdk.jol.info.ClassLayout;

/**
 *@author tom
 *Date  2020/7/21 0021 8:18
 *偏向锁运行 偏向一个锁
 * 交替进行线程 轻量锁
 */
public class Test007  extends Thread{
    private static   Object object=new Object();

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            synchronized (object){
                System.out.println(Thread.currentThread().getName()+",轻量锁运行");
                System.out.println(ClassLayout.parseInstance(object).toPrintable());
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

     /*   Test007 test1=new Test007();
        test1.start();
        Thread.sleep(3000);


        Test007 test2=new Test007();

        test2.start();
        Thread.sleep(3000);*/
         new Test007().start();
        new Test007().start();
        new Test007().start();
        new Test007().start();
    }
}
