package com.taotao.zuoye.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 *@author tom
 *Date  2020/7/15 0015 7:39
 *
 */
public class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.getCause();
        }
        return "异步发送短信成功";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> futureTask = new FutureTask<String>(new MyCallable());
        Thread thread = new Thread(futureTask);
        thread.start();
        String result = futureTask.get();
        System.out.println(result);

    }
}
