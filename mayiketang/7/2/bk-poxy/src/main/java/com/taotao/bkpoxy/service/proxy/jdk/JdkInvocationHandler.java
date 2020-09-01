package com.taotao.bkpoxy.service.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 *@author tom
 *Date  2020/7/5 0005 20:45
 *
 */
public class JdkInvocationHandler implements InvocationHandler {

    /**
     * 目标对象，被代理类
     * @param object
     */
    private  Object target;
    public JdkInvocationHandler(Object object) {
        this.target=object;
    }

    /**
     *
     * @param proxy jdk动态代理生成类
     * @param method 不是真正的目标方法，接口里的方法
     * @param args 代理类的参数
     * @return invoke 使用代理拦截回调
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("<<<<<<<<<<jdk动态代理开始>>>>>>>."+args[0]);
        //d调用目标方法
        Object result=method.invoke(target,args);
        System.out.println("<<<<<<<<<<jdk动态代理执行结束>>>>>>>."+result);

        return result;
    }

    /**
     * 使用jdk创建代理类对象
     * @param <T>
     * @return
     */
    public <T> T getProxy(){
               return (T)Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }
}
