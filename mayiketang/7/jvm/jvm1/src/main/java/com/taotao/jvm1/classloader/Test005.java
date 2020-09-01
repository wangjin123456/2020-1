package com.taotao.jvm1.classloader;

/**
 *@author tom
 *Date  2020/8/8 0008 7:38
 *
 */
public class Test005 {
    public static void main(String[] args) {
        MayiktENtity mayiktENtity =new MayiktENtity();
        System.out.println(mayiktENtity.getClass().getClassLoader());
        Object o=new Object();
        System.out.println(o.getClass().getClassLoader());
    }
}
