package com.taotao.metithread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 *@author tom
 *Date  2020/7/31 0031 8:55
 *future 获取返回结果
 */
public class Test001 implements Callable<String> {



    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> futureTask=new FutureTask<String>(new Test001());
          new Thread(futureTask).start();
          String s=futureTask.get();
        System.out.println("获取返回结果");
    }

    @Override
    public String call() throws Exception {
        try {
            Thread.sleep(3000);
            System.out.println(Thread.currentThread().getName()+"发送短信完成 ");
                 return "发送短信完成";
        } catch (InterruptedException e) {
            e.printStackTrace();
            return  "发送短信失败";
        }
    }
}
