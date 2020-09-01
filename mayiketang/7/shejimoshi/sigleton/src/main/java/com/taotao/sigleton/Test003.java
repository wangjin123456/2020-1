package com.taotao.sigleton;

/**
 *@author tom
 *Date  2020/6/4 0004 8:33
 *
 */
public class Test003 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Singleton07 instance1=Singleton07.INSTANCE;
        Singleton07 instance2=Singleton07.INSTANCE;
        System.out.println(instance1 ==instance2);
        Class<?> aclass=Class.forName("com.taotao.sigleton.Singleton07");
        Object o=aclass.newInstance();
    }
}
