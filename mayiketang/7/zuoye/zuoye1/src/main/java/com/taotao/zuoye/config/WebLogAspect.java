package com.taotao.zuoye.config;

import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 *@author tom
 *Date  2020/7/15 0015 9:46
 *
 */
@Aspect
@Component
@Slf4j
public class WebLogAspect {

    //指定包下的注解, 2个 .. 表示所有的子目录，最后括号里的2个.. 代表所有的参数
    @Pointcut("execution(* com.taotao.zuoye.controller.*.*(..))")
    public void logPointCut() {

    }

    //指定当前方法在logPointCut之前执行
    @Before("logPointCut()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {

        //接收请求，记录请求
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 记录下请求内容
        log.info("请求地址 : " + request.getRequestURL().toString());
        log.info("HTTP METHOD : " + request.getMethod());
        // 获取真实的ip地址
        //logger.info("IP : " + IPAddressUtil.getClientIpAddress(request));
        log.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "."
                + joinPoint.getSignature().getName());
        log.info("参数 : " + Arrays.toString(joinPoint.getArgs()));
        //loggger.info("参数 : " + joinPoint.getArgs());
    }


    @AfterReturning(returning = "ret", pointcut = "logPointCut()")
    //returning的值和 doAfterReturning的参数名一致
    public void doAfterReturning(Object ret) throws Throwable {
        //处理完请求返回内容（返回值太复杂时，打印的是物理存储空间的地址）
        log.info("返回值：" + ret);
    }

    @Around("logPointCut()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        long starttime = System.currentTimeMillis();
        Object ob = pjp.proceed();//ob 为方法的返回值
        log.info("耗时：" + (System.currentTimeMillis() - starttime));
        return ob;
    }
}
