package com.taotao.jvm1.classloader;

/**
 *@author tom
 *Date  2020/8/8 0008 8:04
 *
 */
public class Test0010 {
    public static void main(String[] args) {
        MayiktENtity mayiktENtity=new MayiktENtity();
        System.out.println(mayiktENtity.getClass().getClassLoader());
    }
}
