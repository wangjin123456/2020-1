package com.taotao.mglib.cglib;


import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 *@author tom
 *Date  2020/7/6 0006 9:05
 *
 */
public class CglibMethoodinterceptor implements MethodInterceptor {
    /**
     *
     * @param o
     * @param method
     * @param objects
     * @param methodProxy
     * @return
     * @throws Throwable
     */

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib动态代理开始>>>>");
       Object result=methodProxy.invokeSuper(o,objects);
        System.out.println("cglib 动态代理结束<<<<");

        return null;
    }
}
