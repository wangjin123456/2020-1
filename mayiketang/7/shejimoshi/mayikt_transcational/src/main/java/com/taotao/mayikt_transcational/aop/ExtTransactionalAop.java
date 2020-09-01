package com.taotao.mayikt_transcational.aop;

import com.taotao.mayikt_transcational.util.TransactionUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;

/**
 *@author tom
 *Date  2020/5/28 0028 9:30
 *
 */
@Component
@Slf4j
@Aspect
public class ExtTransactionalAop {
    @Autowired
    private TransactionUtils transactionUtils;

    @Around(value = "@annotation(com.taotao.mayikt_transcational.aop.MeiteTransaction)")
    public Object around(ProceedingJoinPoint joinPoint) {
        TransactionStatus beign = null;
        try {
            beign = transactionUtils.begin();
            log.info(">>>>>>>.开启事务");
            Object result = joinPoint.proceed();//执行目标方法
            log.info(">>>>>>>>>>>>>>>>提交事务");
            transactionUtils.commit(beign);
            return result;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            log.error("回滚事务");
            transactionUtils.rollback(beign);
            return "系统错误";
        }
    }

}
