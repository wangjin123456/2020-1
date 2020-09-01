package com.taotao.demo1.thread.cyclicBarrier;

import java.util.concurrent.CountDownLatch;

/**
 * @author tom
 * @date 2020/4/4 0004 11:06
 */
public class CountDownLatchDemo {
    private CountDownLatch countDownLatch;
    private  int start=10;
    private  int mid=100;
    private  int end=200;
    private  volatile  int tempRes1,tempREs2;
    private int add(int start,int end){
        int sum=0;
        for (int i = start; i <end ; i++) {
            sum+=i;
        }
        return  sum;
    }
    private  int sum(int a,int b){
        return  a+b;
    }

 public  void calculate(){
        countDownLatch =new CountDownLatch(2);
        Thread thread1=new Thread(()->{
            try {
                //确保线程3先与1,2执行。由于countDownLatch 计数不为0而阻塞
                Thread.sleep(100);
                System.out.println(Thread.currentThread().getName()+" : 开始执行");
                tempRes1=add(start,mid);
                System.out.println(Thread.currentThread().getName()+":  calculate  ans: "+tempRes1);

            }catch (InterruptedException e){
                e.printStackTrace();
            }finally {
                countDownLatch.countDown();
            }
        },"线程1");

        Thread thread2=new Thread(()->{
           //确保线程3 先与1,2执行，由于countDownLatch计数不为0而阻塞
            try {
                Thread.sleep(100);
                System.out.println(Thread.currentThread().getName()+":  开始执行");
                tempREs2=add(mid+1,end);
                System.out.println(Thread.currentThread().getName()+": calculate ans "+ tempREs2);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                countDownLatch.countDown();
            }

        },"线程2");


        Thread thread3=new Thread(()->{
           try {

               System.out.println(Thread.currentThread().getName()+": 开始执行");
                  countDownLatch.await();
                  int ans=sum(tempRes1,tempREs2);
               System.out.println(Thread.currentThread().getName()+": calculate ans :"+ans);
           }catch (Exception e){
               e.getCause();
           }
        },"线程3");
        thread3.start();
        thread1.start();
        thread2.start();
 }

    public static void main(String[] args) throws InterruptedException {
        CountDownLatchDemo demo=new CountDownLatchDemo();
        demo.calculate();
        Thread.sleep(1000);
    }

}
