package com.taotao.metithread.fork;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 *@author tom
 *Date  2020/7/31 0031 10:30
 *
 */
public class ForkJoinDemo extends RecursiveTask<Long> {
    //最小分隔单位
    private long max = 200;
    private long start;
    private long end;

    public ForkJoinDemo(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        long sum = 01;
        if (end - start < max) {
            System.out.println(Thread.currentThread().getName() + ",start" + start + ",end" + end);

            for (long i = start; i < end; i++) {
                sum += i;
            }
        } else {
            //400+1 200 1-200, 201-400
            long l = (end + start) / 2;
            ForkJoinDemo left = new ForkJoinDemo(start, l);
            left.fork();
            ForkJoinDemo rigt = new ForkJoinDemo(l + 1, end);
            rigt.fork();
            left.join();
            rigt.join();
            try {
                sum = left.get() + rigt.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        return sum;

    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool forkJoinPool=new ForkJoinPool();
        ForkJoinDemo forkJoinDemo=new ForkJoinDemo(1L,40000L);
        ForkJoinTask<Long> submit=forkJoinPool.submit(forkJoinDemo);
        System.out.println(submit.get());
    }
}
