package com.taotao.metithread.fork;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/**
 *@author tom
 *Date  2020/8/1 0001 7:17
 *使用forkjoin异步发送短信
 */
public class ForkJoinSms  extends RecursiveAction {
    //存放手机号码：
    private List<String> phones;
    private  int start;
    private int end;
    private  int max=100;

    public ForkJoinSms(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected void compute() {
           if(end-start<max){
               System.out.println(Thread.currentThread().getName()+",start:"+start+",end:"+end);



           }else {
               int l=(end+start)/2;
               ForkJoinSms left=new ForkJoinSms(start,l);
               ForkJoinSms right=new ForkJoinSms(l+1,end);
               left.fork();
               right.fork();
               System.out.println(Thread.currentThread().getName()+",start:"+start+",end:"+end);

           }
    }

    public static void main(String[] args) {
        ForkJoinSms forkJoinSms=new ForkJoinSms(1,1000);
        ForkJoinPool forkJoinPool=new ForkJoinPool();

              forkJoinPool.invoke(forkJoinSms);
        // 1-500 1-250 251-500  1-251   1-125  125-251
    }
}
