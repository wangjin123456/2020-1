package com.taotao.zuoye.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 *@author tom
 *Date  2020/7/15 0015 9:17
 *
 */
@Component
@Slf4j
public class AopLogManage {

    @Async
    public void requestLog(JoinPoint joinPoint, HttpServletRequest request) {
        //接收请求，记录请求日志：
        //记录请求内容
        log.info("请求地址：" + request.getRequestURI().toString());
        log.info("HTTP METHOD:" + request.getMethod());
        //获取真实的ip 地址：
        //log.info("IP:"+ IPAddressUtil.isIPv4LiteralAddress(request.getI));
        log.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "."
                + joinPoint.getSignature().getName());
        log.info("参数：" + Arrays.toString(joinPoint.getArgs()));

    }

}
