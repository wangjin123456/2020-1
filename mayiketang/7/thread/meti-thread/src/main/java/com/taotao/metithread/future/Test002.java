package com.taotao.metithread.future;

/**
 *@author tom
 *Date  2020/7/31 0031 9:23
 *实现 MayiktMTallabke 方法
 */
public class Test002 implements MayiktCallable<String> {
    @Override
    public String call() throws Exception {
        try {
            Thread.sleep(3000);
            System.out.println(Thread.currentThread().getName() + "发送短信完成 ");
            return "发送短信完成";
        } catch (InterruptedException e) {
            e.printStackTrace();
            return "发送短信失败";
        }
    }

    public static void main(String[] args) {
        MayiktFutureTask<String> mayiktFutureTask = new MayiktFutureTask<>(new Test002());
        new Thread(mayiktFutureTask).start();
         String s=mayiktFutureTask.get();
        System.out.println("获取返回结果："+s);
    }
}
