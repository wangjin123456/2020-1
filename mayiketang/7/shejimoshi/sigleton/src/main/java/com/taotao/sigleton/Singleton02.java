package com.taotao.sigleton;

/**
 *@author tom
 *Date  2020/6/2 0002 23:36
 *
 */
public class Singleton02 {
    private  static Singleton02 singleton01=null;
    //私有化
    private Singleton02(){

    }
    //效率低

    public synchronized static Singleton02 getInstance(){
        if(singleton01 ==null){
            singleton01=new Singleton02();
        }
        return  singleton01;
    }

    public static void main(String[] args) {
        Singleton02 singleton01= Singleton02.getInstance();
        Singleton02 singleton02= Singleton02.getInstance();
        System.out.println(singleton01==singleton02);
    }
}
