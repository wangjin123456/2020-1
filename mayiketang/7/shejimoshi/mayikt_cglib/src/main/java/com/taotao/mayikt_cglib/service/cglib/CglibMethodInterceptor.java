package com.taotao.mayikt_cglib.service.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 *@author tom
 *Date  2020/5/24 0024 13:01
 *
 */
public class CglibMethodInterceptor  implements MethodInterceptor {

    /***
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
        System.out.println(">>>>>cglib动态代理执行开始<<<<<<");
      Object result=methodProxy.invokeSuper(o,objects);
        System.out.println(">>>>>>>>>>>>cglib动态代理执行结束<<<<<<<<<<<<");
        return result;
    }
}
