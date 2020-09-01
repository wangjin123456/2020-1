package com.taotao.metithread;

/**
 *@author tom
 *Date  2020/7/18 0018 23:14
 *
 */
public class Test003  extends  Thread {
    private  int count=0;
private  Object object =new Object();
    @Override
    public void run() {
        while (count<10000){
            ticket();
        }
    }

    private   void ticket() {
        synchronized(object){
            count++;
            System.out.println(Thread.currentThread().getName()+","+count);
        }

    }


    public static void main(String[] args) throws InterruptedException {
        long starttime=System.currentTimeMillis();
        Test003 test003=new Test003();
        Thread t1=new Thread(test003);
        Thread t2=new Thread(test003);
        t1.start();
        t2.start();
        t1.join();
        t2.join();




        long endtime=System.currentTimeMillis();
        System.out.println(endtime-starttime);
    }
}