package com.taotao.sigleton;

/**
 *@author tom
 *Date  2020/6/4 0004 8:32
 *
 */
public enum  Singleton07 {
    INSTANCE;
    public  void addUser(){
        System.out.println("我是枚举，我是先天性安全的");
    }

    Singleton07() {
        System.out.println(">>>>>>>>>>>Singleton07无参构造函数运行");
    }
}
