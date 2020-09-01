package com.taotao.metithread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/**
 *@author tom
 *Date  2020/7/29 0029 9:21
 *手写线程池
 */
public class MayijtExecutor {
    //存放我们提交任务的线程
    private BlockingQueue<Runnable> runnables;
    //一直运行的线程，核心线程：
    private List<TaskThread> taskThreads;

    public MayijtExecutor(int codeThreads, int queueSize) {
        taskThreads = new ArrayList<TaskThread>();
        runnables = new LinkedBlockingDeque(queueSize);

        for (int i = 0; i < codeThreads; i++) {
            TaskThread taskThread = new TaskThread();
            taskThread.start();
            taskThreads.add(taskThread);
        }
    }

    class TaskThread extends Thread {
        @Override
        public void run() {
            //停掉线程池
            while (runnables.size() > 0 || true) {
                Runnable runnable = runnables.poll();
                if (runnable != null) {
                    runnable.run();
                }
            }
        }
    }

    public boolean executor(Runnable runnable) throws InterruptedException {
        runnables.offer(runnable, 2, TimeUnit.SECONDS);
        return false;
    }

    public static void main(String[] args) throws InterruptedException {
        MayijtExecutor myExecutor = new MayijtExecutor(2, 2);
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            boolean executor = myExecutor.executor(() -> {
                System.out.println(Thread.currentThread().getName() + "," + finalI);
            });


        }
    }
}