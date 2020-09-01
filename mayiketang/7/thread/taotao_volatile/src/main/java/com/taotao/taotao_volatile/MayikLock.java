package com.taotao.taotao_volatile;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *@author tom
 *Date  2020/7/10 0010 8:22
 *公平锁/非公平锁
 */
public class MayikLock  implements  Runnable{
    private  static Lock lock=new ReentrantLock(false);//false非公平锁，默认，true公平锁
    private static  int count=0;

    public static void main(String[] args) {
            long starttime=System.currentTimeMillis();
        ArrayList<Thread> thraeds=new ArrayList<>();
        for (int i = 0; i <10 ; i++) {
            Thread thread=new Thread(new MayikLock());
               thread.start();
                thraeds.add(thread);
        }
        thraeds.forEach((t)->{
            try {
                t.join();
            }catch (Exception e){
                e.getCause();
            }
        });
        long endTime=System.currentTimeMillis();
        System.out.println(endTime -starttime);
    }

    @Override
    public void run() {
        while (count<200){
           // lock.lock();;
            createCount();
          //  lock.unlock();
        }
    }

    private synchronized void createCount() {
        System.out.println(Thread.currentThread().getName()+",count:"+count);
        count++;
    }
}
