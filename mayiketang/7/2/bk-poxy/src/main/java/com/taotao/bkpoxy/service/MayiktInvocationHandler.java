package com.taotao.bkpoxy.service;

import java.lang.reflect.Method;

/**
 *@author tom
 *Date  2020/7/5 0005 22:42
 *
 */
public interface MayiktInvocationHandler {

    public  Object invoke(Object proxy, Method method, Object[] args)
        throws Throwable;


}
