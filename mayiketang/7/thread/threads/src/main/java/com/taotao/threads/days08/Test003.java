package com.taotao.threads.days08;

import java.util.HashMap;

/**
 *@author tom
 *Date  2020/8/2 0002 9:36
 *强引用
 */
public class Test003 {
    public static void main(String[] args) {
        OrderEntity o1=new OrderEntity(11,"333");
            OrderEntity o2=o1;
        System.out.println(o2);
        o1=null;
        System.gc();
        System.out.println(o2);
        HashMap<Thread,String>threadStringHasgMap=new HashMap<>();
        threadStringHasgMap.put(Thread.currentThread(),"99");
        System.out.println(threadStringHasgMap.get(Thread.currentThread()));
    }
}
