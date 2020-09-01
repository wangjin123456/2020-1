package com.taotao.springbootthread.manage;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import sun.net.util.IPAddressUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 *@author tom
 *Date  2020/6/24 0024 7:17
 *
 */
@Slf4j
@Component
public class AopManage {

    @Async
    public  void asyncAopLog(JoinPoint joiPoint, HttpServletRequest request){
        //记录下请求内容
        log.info("请求地址："+request.getRequestURI().toString());
        log.info("HTTP METHOD:"+request.getMethod());
        //获取真实的IP地址
  log.info("CLASS_METHOD:"+joiPoint.getSignature().getDeclaringTypeName()+"."+joiPoint.getSignature().getName());
  log.info("CLASS_METHOD:"+ Arrays.toString(joiPoint.getArgs()));
    }
}
