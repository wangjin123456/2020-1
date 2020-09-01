package com.taotao.threads.days08;

import java.lang.ref.WeakReference;

/**
 *@author tom
 *Date  2020/8/2 0002 9:45
 *软引用：
 */
public class Test004 {
    public static void main(String[] args) {
        OrderEntity o1=new OrderEntity(2,"3");
        WeakReference<OrderEntity> o2=new WeakReference<>(o1);
                o1=null;
        System.out.println(o2.get());
        System.gc();
        System.out.println(o2.get());

    }
}
