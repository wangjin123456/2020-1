package com.taotao.springbootthread.aop;

import com.taotao.springbootthread.manage.AopManage;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import sun.net.util.IPAddressUtil;

import javax.servlet.http.HttpServletRequest;

/**
 *@author tom
 *Date  2020/6/24 0024 7:26
 *
 */
@Aspect
@Component
@Slf4j
public class WebLogAspect {
    @Autowired
    private AopManage aopManage;


    /**
     * 指定 com.taotao.springbootthread.service 包下的注解
     */
    @Pointcut("execution( * com.taotao.springbootthread.service.*.*(..))")
    public  void LogPointCut(){

    }


    @Before("LogPointCut()")
    public void doBefore(JoinPoint joinPoint)throws  Exception{
        //接受到请求，记录请求内容
        ServletRequestAttributes attributes= (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request=attributes.getRequest();

        // 记录下请求内容
       log.info("请求地址 : " + request.getRequestURL().toString());
      log.info("HTTP METHOD : " + request.getMethod());
        // 获取真实的ip地址

//        log.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "."
//                + joinPoint.getSignature().getName());
//        log.info("参数 : " + Arrays.toString(joinPoint.getArgs()));
//        // 将日志存入到redis、mongdb
        aopManage.asyncAopLog(joinPoint,request);
    }

    /**
     * 在指定方法后返回
     */

    @AfterReturning(returning = "ret",pointcut = "LogPointCut()")
    public  void doAfterReturning(Object ret)throws  Throwable{
        // 处理完请求，返回内容(返回值太复杂时，打印的是物理存储空间的地址)
        log.info("返回值 : " + ret);
    }
    @Around("LogPointCut()")
    public  Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        long startTime=System.currentTimeMillis();
        Object ob=pjp.proceed();//ob为方法返回值
        log.info("耗时："+(System.currentTimeMillis()-startTime));
        return  ob;
    }
}
