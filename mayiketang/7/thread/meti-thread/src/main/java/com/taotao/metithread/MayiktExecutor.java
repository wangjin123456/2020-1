package com.taotao.metithread;

import java.util.concurrent.*;

/**
 *@author tom
 *Date  2020/7/30 0030 7:16
 *
 */
public class MayiktExecutor {


    public void executor() {

    }

    public static ExecutorService newFixedThreadPool(int corePoolSize, int maximumPoolSize, int queue ) {

        return new ThreadPoolExecutor(corePoolSize, maximumPoolSize, 0L, TimeUnit.SECONDS,
                //拒绝策略
                new LinkedBlockingQueue<>(queue),new MyRejectedExecutionHandler());
    }

    public static void main(String[] args) {

        ExecutorService executorService = MayiktExecutor.newFixedThreadPool(10, 15, 5);
        for (int i = 0; i < 21; i++) {
            int finalI = i;
            executorService.execute(() -> {

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() + ":" + finalI);
            });
        }
    }
}
