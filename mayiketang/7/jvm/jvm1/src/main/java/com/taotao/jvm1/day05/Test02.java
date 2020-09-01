package com.taotao.jvm1.day05;

/**
 *@author tom
 *Date  2020/8/14 0014 8:01
 *
 */
public class Test02 {
    public static void main(String[] args) {

        String s1="a";
        String s2="b";
        String s3="a"+"b";
        String s4=s1+s2;
        String s5="ab";
        String s6=s4.intern();
        System.out.println(s3==s4);
        System.out.println(s3==s5);
        System.out.println(s3==s6);
        // ==比较地址
    }
}
