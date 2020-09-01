package com.taotao.jvm1.day07;

import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.ArrayList;

/**
 *@author tom
 *Date  2020/8/18 0018 7:56
 *
 */
public class Test03 {
    public static void main(String[] args) {
      //  Strong();
         soft();
    }

    /**
     * 软引用
     */
    private static void soft() {
        ReferenceQueue<byte[]> referenceQueue=new ReferenceQueue<>();
        ArrayList<SoftReference<byte[]>> objects=new ArrayList<>();
        for (int i = 0; i <10 ; i++) {
            SoftReference<byte[]> softReference=new SoftReference<>(new byte[4*1024*1024],referenceQueue);
            objects.add(softReference);
        }
        Reference<? extends  byte[]> poll=referenceQueue.poll();
        while (poll !=null){
          //  System.out.println(poll.get());
            objects.remove(poll);
            poll=referenceQueue.poll();
        }
        System.out.println("打印结果：");
        objects.forEach((t)->{
            System.out.println(t.get());
        });
    }

    /**
     * 强引用
     */
    private static void Strong() {
        ArrayList<byte[]> objects=new ArrayList<>();
        for (int i = 0; i <10 ; i++) {
            //强引用
            objects.add(new byte[4*1024*1024]);
        }
        //  System.in.read();

    }

}
