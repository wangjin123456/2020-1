package com.taotao.metithread;

import java.util.concurrent.atomic.AtomicLong;

/**
 *@author tom
 *Date  2020/7/18 0018 21:22
 *
 */
public class Test002  extends  Thread{
    private  static AtomicLong atomicLong=new AtomicLong();

    @Override
    public void run() {
        while (atomicLong.get()<10000){

        long l=atomicLong.incrementAndGet();
        System.out.println(Thread.currentThread().getName()+","+l);
    }

    }

    public static void main(String[] args) throws InterruptedException {
        Long starttime=System.currentTimeMillis();
        Test002 t1=new Test002();
        Test002 t2=new Test002();
        t1.start();
      //  t2.start();
        t1.join();
      //  t2.join();
        Long end=System.currentTimeMillis();
        System.out.println(end-starttime);
    }
}


