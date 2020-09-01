package com.taotao.zuoye.single;

/**
 *@author tom
 *Date  2020/7/12 0012 9:18
 *静态内部类
 */
public class Singleton07 {
    private Singleton07() {
        System.out.println(">>>>>>>>>Singleton07");
    }

    private static class SingletonHolder {
        private static final Singleton07 singleton07 = new Singleton07();
    }

    public static final Singleton07 getInstance() {
        return SingletonHolder.singleton07;
    }

    public static void main(String[] args) {
        Singleton07 singleton07 = Singleton07.getInstance();
        Singleton07 singleton017 = Singleton07.getInstance();
        System.out.println(singleton07 == singleton017);
    }
}
