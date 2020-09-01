package com.taotao.sigleton;

/**
 *@author tom
 *Date  2020/6/3 0003 9:46
 *
 */
public class Singleton05 {
    private  static  Singleton05 singleton05 =null;
    private  Singleton05(){}
    static {
        System.out.println("当前class被加载");
        singleton05=new Singleton05();
    }

    public  static  Singleton05 getInstance(){
        return  singleton05;
    }

    public static void main(String[] args) {
        Singleton05 instance01=Singleton05.getInstance();
        Singleton05 instance02=Singleton05.getInstance();
        System.out.println(instance01==instance02);
    }

}
