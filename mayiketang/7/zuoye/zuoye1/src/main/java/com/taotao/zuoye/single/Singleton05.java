package com.taotao.zuoye.single;

/**
 *@author tom
 *Date  2020/7/12 0012 8:16
 *饿汉式公有
 */
public class Singleton05 {
    public static final Singleton05 singleton04 = new Singleton05();

    private Singleton05() {

    }

    private static Singleton05 getInstance() {

        return singleton04;
    }

    public static void main(String[] args) {
        Singleton05 singleton04 = Singleton05.getInstance();
        Singleton05 singleton041 = Singleton05.getInstance();
        System.out.println(singleton04 == singleton041);
    }

}
