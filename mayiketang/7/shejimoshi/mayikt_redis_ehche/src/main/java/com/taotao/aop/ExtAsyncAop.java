package com.taotao.aop;

import com.taotao.decorate.MayiktCache;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 *@author tom
 *Date  2020/5/26 0026 9:54
 *自定义aop注解
 */
@Aspect
@Component
@Slf4j
public class ExtAsyncAop {
    @Autowired
    private MayiktCache mayiktCache;

    /**
     * 使用aop拦截我们的方法上是否使用缓存注解
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Around(value = "@annotation(com.taotao.aop.ExtMeiteCache)")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        //目标方法
     /*   log.info("目标方法开始执行");
        Object result=joinPoint.proceed();//执行目标方法
        log.info("目标方法结束执行");*/
        //1 拼接缓存的key
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        //获取目标
        Method targetMethod = methodSignature.getMethod();
        String key = targetMethod.getName() + Arrays.toString(targetMethod.getParameterTypes()) + Arrays.toString(joinPoint.getArgs());
        Object result = mayiktCache.getCacheEntity(key,targetMethod.getReturnType(), joinPoint);
        return result;
    }
}
