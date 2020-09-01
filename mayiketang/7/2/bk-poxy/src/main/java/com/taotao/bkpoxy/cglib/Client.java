package com.taotao.bkpoxy.cglib;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;

/**
 *@author tom
 *Date  2020/7/6 0006 7:11
 *生成CGLIB 代理类对象的方法
 */
public class Client {

    public static void main(String[] args) {
        //代理类class文件存入本地磁盘方便我们反编译查看源码
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY,"D:\\code");
        //通过CGLIB动态代理获取代理对象的过程
        Enhancer enhancer =new Enhancer();
        //设置enhancer对象的父类
        enhancer.setSuperclass(HelloService.class);
        //设置enhancer的回调对象
        enhancer.setCallback(new MyMethodInterceptor());
        //创建代理对象
        HelloService proxy=(HelloService)enhancer.create();
        //通过代理对象调用目标方法
        proxy.sayHello();



    }
}
