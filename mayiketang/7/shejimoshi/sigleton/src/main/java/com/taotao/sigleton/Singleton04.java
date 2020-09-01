package com.taotao.sigleton;

/**
 * 恶汉单例
 *@author tom
 *Date  2020/6/3 0003 9:19
 *
 */

public class Singleton04 {
    //当class被加载的时候就创建对象
    private static  Singleton04 singleton04=new Singleton04();
    private  Singleton04(){

    }
    public  static  Singleton04 getInstance(){
        return  singleton04;
    }

    public static void main(String[] args) {
        Singleton04 instance1=Singleton04.getInstance();
        Singleton04 instance2=Singleton04.getInstance();
        System.out.println(instance1==instance2);
    }
}
