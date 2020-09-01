package com.taotao.zuoye.single;

/**
 *@author tom
 *Date  2020/7/12 0012 9:14
 *静态代码块
 */
public class Singleton06 {
    private static Singleton06 singleton06;

    static {
        singleton06 = new Singleton06();
    }

    public static Singleton06 getInstance() {
        return singleton06;
    }

    public static void main(String[] args) {
        Singleton06 singleton06 = Singleton06.getInstance();
        Singleton06 singleton061 = Singleton06.getInstance();
        System.out.println(singleton06 == singleton061);
    }
}
