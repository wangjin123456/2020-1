package com.taotao.sigleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 *@author tom
 *Date  2020/6/3 0003 9:55
 *反射机制序列化对象
 */
public class Test1 {
    public static void main(String[] args) throws Exception {

       //使用反射机制创建我们的对象
        Class<?> aclass=Class.forName("com.taotao.sigleton.Singleton01");
    //    Constructor<?> constructor=aclass.getConstructor();
        Constructor<?> constructor=aclass.getDeclaredConstructor();
        constructor.setAccessible(true);
       Singleton01 instance2= (Singleton01) constructor.newInstance();
        Singleton01 singleton01=Singleton01.getInstance();

        System.out.println(singleton01==instance2);
    }
}
