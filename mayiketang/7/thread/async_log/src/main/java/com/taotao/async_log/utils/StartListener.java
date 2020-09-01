package com.taotao.async_log.utils;

import ch.qos.logback.classic.AsyncAppender;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName StartListener
 * @Author 蚂蚁课堂余胜军 QQ644064779 www.mayikt.com
 * @Version V1.0
 **/
@Slf4j
@Component
public class StartListener implements ApplicationListener<ApplicationReadyEvent> {
    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        log.info("当前项目启动成功");
        start();
    }

    public void start() {
        Worker worker = new Worker();
        //单独开启一个线程异步写日志
        worker.start();
    }

    class Worker extends Thread {
        @Override
        public void run() {
            for (; ; ) {
                String mtLog = LogBlockingQueue.getLog();
                if (!StringUtils.isEmpty(mtLog)) {
                    //将日志内容写入到硬盘中
                    LogException.writeErrorMsg(mtLog);
                    log.info("采用日志队列异步写入日志:{}{}", mtLog);
                }
            }

        }
    }

}
