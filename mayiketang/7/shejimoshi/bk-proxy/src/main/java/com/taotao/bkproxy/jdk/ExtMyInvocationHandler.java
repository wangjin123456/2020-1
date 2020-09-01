package com.taotao.bkproxy.jdk;

import java.lang.reflect.Method;

/**
 *@author tom
 *Date  2020/5/18 0018 7:22
 *
 */
public interface ExtMyInvocationHandler {

    /***
     * 回调执行invoke 方法
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
     Object invoke(Object proxy, Method method, Object[] args) throws Throwable;

}
