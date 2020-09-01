package com.taotao.metithread;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/**
 *@author tom
 *Date  2020/7/29 0029 8:38
 *阻塞与非阻塞
 */
public class Test042 {
    public static void main(String[] args) throws InterruptedException {
        LinkedBlockingDeque<String> strings=new LinkedBlockingDeque<>(3);
        strings.offer("mayikt");
        strings.offer("meite");
        strings.offer("wwss");
        strings.offer("23");
        boolean xiaowie=strings.offer("xiaowie",3,TimeUnit.SECONDS);
        System.out.println(xiaowie);
//        System.out.println(strings.peek());
//        System.out.println(strings.peek());
//        System.out.println(strings.peek());
//        System.out.println(strings.peek());
        System.out.println(strings.poll());
        System.out.println(strings.poll());
        System.out.println(strings.poll());
        System.out.println(strings.poll(3, TimeUnit.SECONDS));
        //poll取出成功的话会将元素从队列删除
       //peek 获取元素不删除


    }
}
