package com.taotao.zuoye.single;

/**
 *@author tom
 *Date  2020/7/11 0011 22:48
 *能够保证线程安全，只会在创建该单例对象的时候上锁，获取单例对象时候不会上锁，效率比较高
 */
public class Singleton03 {
    private static Singleton03 singleton03;

    public static Singleton03 getInstance() {
        //第一次查看
        if (singleton03 == null) {
            //第二次查看
            synchronized (Singleton03.class) {
                if (singleton03 == null) {
                    singleton03 = new Singleton03();
                }
            }
        }
        return singleton03;
    }

    public static void main(String[] args) {

        Singleton03 singleton01 = getInstance();
        Singleton03 singleton03 = getInstance();
        System.out.println(singleton01 == singleton03);
    }

}
