package com.taotao.hashmap001;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *@author tom
 *Date  2020/9/27 0027 6:59
 *乐观锁 自旋
 */
public class Test006 {
    private  static AtomicInteger atomicInteger=new AtomicInteger(0);

    public static void main(String[] args) {

        boolean b=atomicInteger.compareAndSet(0,1);
        System.out.println(b);
    }



}
