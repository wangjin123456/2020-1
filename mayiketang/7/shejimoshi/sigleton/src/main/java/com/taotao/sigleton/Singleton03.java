package com.taotao.sigleton;

/**
 *@author tom
 *Date  2020/6/2 0002 23:36
 *
 */
public class Singleton03 {
    private  static Singleton03 singleton03=null;
    //私有化
    private Singleton03(){

    }

    public  static Singleton03 getInstance(){
        //上锁创建对象 第一次判断
        
        if(singleton03 ==null){
            synchronized (Singleton03.class){
                //第二次判断
                if(singleton03==null){
                    singleton03=new Singleton03();
                }
            }

        }
        return  singleton03;
    }

    public static void main(String[] args) {
        Singleton03 singleton03= Singleton03.getInstance();
        Singleton03 singleton02= Singleton03.getInstance();
        System.out.println(singleton03==singleton02);
    }
}
