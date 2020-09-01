package com.taotao.async_log.mq;

import org.apache.logging.log4j.util.Strings;

import java.util.concurrent.LinkedBlockingDeque;

/**
 *@author tom
 *Date  2020/8/5 0005 9:30
 *
 */
public class MQServer {
    public static void main(String[] args) throws InterruptedException {
        //定义mq服务器端
       LinkedBlockingDeque<String> linkedBlockingDeque= new LinkedBlockingDeque<String>();
       // System.out.println(linkedBlockingDeque.poll());
 //创建生产线程
        Thread producer=new Thread(()->{
            for (int i = 0; i < 10; i++) {
                linkedBlockingDeque.offer(i+"");
                System.out.println(Thread.currentThread().getName()+",向mq服务器端存放消费内容："+i);

            }

        },"生产线程：");
        //主线程等待，生产线程投递万全部消息后则开始继续向下执行
     producer.start();
       producer.join();


        new Thread(()->{
            for (;;) {
              String msg=linkedBlockingDeque.poll();
              if(Strings.isEmpty(msg)){
                  return;
              }
                System.out.println(Thread.currentThread().getName()+"，从mq服务器取出消息："+msg);
            }

        },"消费线程线程：").start();
        //主线程等待，生产线程投递万全部消息后则开始继续向下执行








   }







}
