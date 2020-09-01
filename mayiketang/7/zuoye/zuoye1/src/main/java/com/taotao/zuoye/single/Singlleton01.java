package com.taotao.zuoye.single;

/**
 *@author tom
 *Date  2020/7/11 0011 22:36
 *懒汉式： 当真正需要获取对象的时候，采取创建对象，改写法存在线程安全问题
 *  */
public class Singlleton01 {
    private static Singlleton01 singlleton01 = null;

    //私有构造函数
    private Singlleton01() {

    }

    /**
     * 懒汉式，线程不安租全
     */

    public static Singlleton01 getInstance() {
        if (singlleton01 == null) {
            singlleton01 = new Singlleton01();
        }
        return singlleton01;
    }

    public static void main(String[] args) {
        Singlleton01 singlleton01 = Singlleton01.getInstance();
        Singlleton01 singlleton011 = Singlleton01.getInstance();
        System.out.println(singlleton01 == singlleton011);
    }
}
