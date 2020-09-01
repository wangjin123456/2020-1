package com.taotao.zuoye.single;

/**
 *@author tom
 *Date  2020/7/11 0011 22:43
 *
 */
public class Singleton02 {
    private static Singleton02 Singleton02 = null;

    //私有构造函数
    private Singleton02() {

    }

    /**
     * 懒汉式，线程安全
     * 已经创建的对象，获取该单例对象的时候还需要上锁效率比较低
     */

    public static synchronized Singleton02 getInstance() {
        if (Singleton02 == null) {
            Singleton02 = new Singleton02();
        }
        return Singleton02;
    }

    public static void main(String[] args) {
        Singleton02 Singleton02 = getInstance();
        Singleton02 Singleton021 = getInstance();
        System.out.println(Singleton02 == Singleton021);
    }
}
