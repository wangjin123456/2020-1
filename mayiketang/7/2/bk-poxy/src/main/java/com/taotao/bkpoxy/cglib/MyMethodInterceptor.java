package com.taotao.bkpoxy.cglib;


import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 *@author tom
 *Date  2020/7/6 0006 7:04
 *
 */
public class MyMethodInterceptor  implements MethodInterceptor {
    /**
     *
     * @param o   cglib  生成的代理对象
     * @param method 被代理对象的方法
     * @param objects 方法入参
     * @param methodProxy 代理方法
     * @return
     * @throws Throwable
     */

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("========插入前置通知===========");
      Object object=methodProxy.invokeSuper(o,objects);
        System.out.println("=======插入后置通知====");
        return object;
    }
}
