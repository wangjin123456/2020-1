package com.taotao.async_log.utils;

import java.util.concurrent.ArrayBlockingQueue;

/**
 *@author tom
 *Date  2020/8/3 0003 9:24
 *
 */
public class LogBlockingQueue {
    private static int maxCapacity = 256;
    private static ArrayBlockingQueue<String> logBlockingQueue = new ArrayBlockingQueue<String>(maxCapacity);

    /**
     * 像队列里存放日志内容
     * 业务线程
     * @param log
     */
    public  static boolean addLog(String log) {
        return logBlockingQueue.offer(log);

    }

    /**
     * 像队列取出日志内
     * 日志线程
     * * @return
     */
    public static String getLog() {
        return  logBlockingQueue.poll();
    }

}
