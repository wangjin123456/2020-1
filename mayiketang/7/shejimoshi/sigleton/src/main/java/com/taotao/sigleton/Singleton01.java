package com.taotao.sigleton;

import java.io.Serializable;

/**
 *@author tom
 *Date  2020/6/2 0002 23:36
 *
 */
public class Singleton01 implements Serializable {
    private  static  Singleton01 singleton01=null;
    //私有化
    private  Singleton01() throws Exception {
        if(singleton01 !=null){
            throw new Exception("已创建");
        }else {
            singleton01 =this;
        }
        System.out.println("初始化对象");
    }

    public  static  Singleton01 getInstance() throws Exception {
        if(singleton01 ==null){

            singleton01=new Singleton01();
        }
        return  singleton01;
    }

    public static void main(String[] args) throws Exception {
        Singleton01 singleton01=Singleton01.getInstance();
        Singleton01 singleton02=Singleton01.getInstance();
        System.out.println(singleton01==singleton02);
    }
    /***
     * 名称写死
     * 序列化生成回调方法， 通过方法实现反序列化生成单例对象
     */

    public  Object readResolve(){
        return  singleton01;
    }
}
