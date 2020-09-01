package com.taotao.bkproxy.jdk;

import com.taotao.bkproxy.proxy.JavaClassLoader;
import com.taotao.bkproxy.proxy.MyProxy;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 *@author tom
 *Date  2020/5/18 0018 7:26
 *
 */
public class MYInvocationHandler implements  ExtMyInvocationHandler {
    //目标对象，需要代理的对象‘
    private Object object;

    public MYInvocationHandler(Object object) {
        this.object = object;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("jdk动态代理继承模式方式开始：");
        Object o = method.invoke(object, args);//目标方法
        System.out.println("jdk动态代理调用方法结束：");
        return o;
    }
    /**
     * 通过jdk 动态代理反射技术生成代理对象，调用代理对象的方法的时候会走InvocationHandlerinvoke方法
     * @param <T>
     * @return
     */
    public  <T> T getProxy(){
     return  (T) MyProxy.newProxyInstance(new JavaClassLoader(),object.getClass().getInterfaces()[0],this);

    }
}
