package com.taotao.async_log.controller;

import com.taotao.async_log.utils.LogBlockingQueue;
import com.taotao.async_log.utils.LogException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *@author tom
 *Date  2020/8/3 0003 9:23
 *
 */
@RestController
@Slf4j
public class PayController {
    @RequestMapping("/topay")
    public  String toPay(String payId,String payMoney){
        //记录日志到硬盘
        String payLog=System.currentTimeMillis()+","+payId+","+payMoney;
       boolean result=LogBlockingQueue.addLog(payLog);
       if(!result) {
           //同步写日志
           //如果队列满了，用户线程自己写日志
           LogException.writeErrorMsg(payLog);
       }
        return  "success";

    }

}
