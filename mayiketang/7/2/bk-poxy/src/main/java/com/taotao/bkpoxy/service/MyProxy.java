package com.taotao.bkpoxy.service;

/**
 *@author tom
 *Date  2020/7/5 0005 22:41
 *
 */
public class MyProxy {
    public  Object newProxyInstance(ClassLoader classLoader,Class classInfo,MayiktInvocationHandler h){
        //1，根据接口的信息拼接java 源代码

        //2, 将java 源代码写入到本地磁盘

        //3, 将源代码编译为class文件

        //4 使用类加载器读取class文件
        return null;
    }

}
