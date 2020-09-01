package com.taotao.jvm1.day04;

/**
 *@author tom
 *Date  2020/8/12 0012 8:33
 *栈帧空间
 */
public class Test005 {

    public int mk01() {
        //一个方法一个栈帧空间
        return mk02();
    }

    private int mk02() {
        int j = 1;
        int z = j + 1;
        return j;

    }

    /**
     * 3个栈帧
     * @param args
     */
    public static void main(String[] args) {
        Test005 a = new Test005();
        Test005 b = a;
        System.out.println(a.mk01());
        new Thread().start();
    }
}
