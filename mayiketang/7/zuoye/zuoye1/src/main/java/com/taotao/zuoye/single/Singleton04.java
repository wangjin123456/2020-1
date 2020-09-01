package com.taotao.zuoye.single;

/**
 *@author tom
 *Date  2020/7/12 0012 8:16
 *饿汉式私有
 */
public class Singleton04 {
    private static final Singleton04 singleton04 = new Singleton04();

    private Singleton04() {

    }

    private static Singleton04 getInstance() {

        return singleton04;
    }

    public static void main(String[] args) {
        Singleton04 singleton04 = Singleton04.getInstance();
        Singleton04 singleton041 = Singleton04.getInstance();
        System.out.println(singleton04 == singleton041);
    }

}
