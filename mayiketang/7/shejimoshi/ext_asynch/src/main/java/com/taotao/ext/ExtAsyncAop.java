package com.taotao.ext;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;

import static java.util.concurrent.Executors.newFixedThreadPool;

/**
 *@author tom
 *Date  2020/5/22 0022 8:53
 *
 */
@Component
@Aspect

public class ExtAsyncAop {
    private ExecutorService executorService;

    public ExtAsyncAop(ExecutorService executorService) {
       executorService= newFixedThreadPool(10);
    }

    @Around(value = "@annotation(com.taotao.ext.ExtAsync)")
    public  void doBefore(ProceedingJoinPoint joinPoint)throws  Throwable{
                 //直接读取到方法上有加上ExtAsync
                  //执行目标方法
        System.out.println("拦截到方法上有ExAsync");
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                //直接获取到方法上有加上ExtAsync
                 try {
                     joinPoint.proceed();
                 }catch (Exception e){
                     e.getCause();
                 } catch (Throwable throwable) {
                     throwable.printStackTrace();
                 }
            }
        });

    }
}
