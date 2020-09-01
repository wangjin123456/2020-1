package com.taotao.jdk;

import com.taotao.ext.ExtAsync;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *@author tom
 *Date  2020/5/21 0021 18:29
 *jdk 动态代理
 */
public class MayiktInvocationHandler implements InvocationHandler {
    //目标对象
    private Object target;
    private ExecutorService executorService;


    public MayiktInvocationHandler(Object target) {
        this.target = target;
        executorService = Executors.newFixedThreadPool(10);

    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //使用反射技术执行目标方法

        //拦截注解
        //  ExtAsync extAsync = method.getDeclaredAnnotation(ExtAsync.class);
        //根据接口信息查询到目标对象的方法
        Method methodimpl = target.getClass().getMethod(method.getName(), method.getParameterTypes());
        ExtAsync extAsync = methodimpl.getDeclaredAnnotation(ExtAsync.class);
        if (extAsync == null) {
            //该方法上没有加上异步注解直接调用目标方法
            return method.invoke(target, args);
        }
        //单独开启一个线程异步处理目标方法
        //Object obj = method.invoke(target, args);

        executorService.execute(new Runnable() {

            @Override
            public void run() {
                try {
                    method.invoke(target, args);

                } catch (Exception e) {
                    e.getCause();
                }

            }
        });
        return null;
    }

    /**
     * 生成代理类
     */
    public <T> T getProxy() {
        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), this);
    }
}
