package com.taotao.metithread;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 *@author tom
 *Date  2020/7/30 0030 9:06
 *
 */
public class MyRejectedExecutionHandler implements RejectedExecutionHandler {


    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        if (r != null) {
            r.run();
        }
        System.out.println("线程池满了，拒绝线程任务" + r.toString());
    }
}
