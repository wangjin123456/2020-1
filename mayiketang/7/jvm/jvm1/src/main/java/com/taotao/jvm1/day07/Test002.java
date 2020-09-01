package com.taotao.jvm1.day07;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 *@author tom
 *Date  2020/8/17 0017 10:28
 *强引用
 */
public class Test002 {
    public static void main(String[] args) {
        //强引用
        UserEntity user1=new UserEntity("mk");
//        UserEntity u2=user1;
//        user1=null;
//        System.out.println(u2);
         //弱引用
//        WeakReference<UserEntity> user2=new WeakReference<>(user1);
//        user1=null;
//        //触发gc
//        System.gc();
//
//        System.out.println(user2.get());
                //虚引用
        ReferenceQueue<Object> referenceQueue=new ReferenceQueue<>();
        PhantomReference<UserEntity> user2=new PhantomReference<UserEntity>(user1,referenceQueue);
        System.out.println(user2.get());

    }
}
