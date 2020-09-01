package com.taotao.zuoye.jdk.service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 *@author tom
 *Date  2020/7/10 0010 18:21
 *
 */
public class JdkInvocationHandler implements InvocationHandler {
    //目标对象
    private Object target;

    public JdkInvocationHandler(Object target) {
        this.target = target;
    }

    /**
     *
     * @param proxy  使用jdk程序生成的代理类
     * @param method  目标方法
     * @param args  方法需要传递的参数
     * @return
     * @throws Throwable
     */

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("使用jdk动态代理打印日志开始" + args[0]);
        Object result = method.invoke(target, args);
        System.out.println("使用jdk 动态代理结束" + args[1]);
        return result;
    }

    /**
     * 生成代理类
     * @param <T>
     * @return
     */
    public <T> T getProxy() {
        /**
         *   一个ClassLoader对象，定义了由哪个ClassLoader对象来对生成的代理对象进行加载
         *
         *
         */
        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }
}
