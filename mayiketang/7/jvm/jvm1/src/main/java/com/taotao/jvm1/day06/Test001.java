package com.taotao.jvm1.day06;


import org.openjdk.jol.info.ClassLayout;

/**
 *@author tom
 *Date  2020/8/16 0016 6:48
 *
 */
public class Test001 {
    public static void main(String[] args) {
           UserEntity userEntity=new UserEntity();
        System.out.println(ClassLayout.parseInstance(userEntity).toPrintable());
        System.out.println(Integer.toHexString(userEntity.hashCode()));
    }
}
