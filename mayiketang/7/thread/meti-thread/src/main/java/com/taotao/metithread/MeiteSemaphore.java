package com.taotao.metithread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 *@author tom
 *Date  2020/7/28 0028 9:17
 *手写Semapore 信号量
 */
public class MeiteSemaphore {
    private Sync sync;

    private MeiteSemaphore(int count) {
        sync = new Sync(count);
    }

    public void acquire() {
        sync.acquireShared(1);
    }

    public  void release(){

        sync.releaseShared(1);
    }

    class Sync extends AbstractQueuedSynchronizer {
        public Sync(int count) {
            setState(count);
        }

        @Override
        protected int tryAcquireShared(int arg) {
            for (; ; ) {
                int oldState = getState();
                int newState = oldState - arg;
                if (compareAndSetState(oldState, newState)) {
                    return newState < 0 ? -1 : 1;
                }
            }
        }

        @Override
        protected boolean tryReleaseShared(int arg) {
            for (; ; ) {
                int oldState = getState();
                int newState = oldState+arg;

                if(newState<oldState){
                    throw  new Error(" not found");
                }
                if (compareAndSetState(oldState, newState)) {
                    return true;
                }
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        //设置aqs状态为5 只能限制5个线程执行代码
        MeiteSemaphore semaphore= new MeiteSemaphore(5);
        for (int i = 0; i <= 20; i++) {
            new Thread(()->{


                    //aqs状态减1如果状态为0的情况下会编外阻塞
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"获取门票：");
                    //aqs状态加1同时唤醒阻塞的状态
                    semaphore.release();

            }).start();

        }
    }
}
