package com.taotao.threads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 *@author tom
 *Date  2020/6/23 0023 9:02
 *
 */
public class MyCallable  implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName()+"正在一步发送短信");
        try {
            Thread.sleep(3000);
        }catch (Exception e){
            e.getCause();
        }
        return  "发送短信成功";

    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> futureTask=new FutureTask<String>(new MyCallable());
        Thread thread=new Thread(futureTask);
        thread.start();
        String result=futureTask.get();
        System.out.println(Thread.currentThread().getName()+result);



    }
}
