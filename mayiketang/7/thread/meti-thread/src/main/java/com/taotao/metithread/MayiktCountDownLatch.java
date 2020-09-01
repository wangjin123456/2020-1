package com.taotao.metithread;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 *@author tom
 *Date  2020/7/28 0028 8:04
 *手写countdownlatch
 */
public class MayiktCountDownLatch {
    private Sync sync;

    public MayiktCountDownLatch(int count) {
        sync = new Sync(count);
    }

    //当前线程变为阻塞
    public void await() {
        sync.acquireShared(1);
    }


    public void countDown() {
        sync.releaseShared(1);
    }

    class Sync extends AbstractQueuedSynchronizer {
        public Sync(int count) {
            setState(count);
        }

        /**
         * 如果返回值小于0 的情况下则让当前线程放入到aqs双向链表中
         * @param arg
         * @return
         */
        @Override
        protected int tryAcquireShared(int arg) {
            //如果aqs的状态>0，则让当前线程放入到aqs双向链表中，返回《0 -1；
            return getState() == 0 ? 1 : -1;

        }

        //如果当期线程返回true 则唤醒刚才阻塞的线程
        @Override
        protected boolean tryReleaseShared(int arg) {
            for (; ; ) {
                int oldState = getState();
                if (oldState == 0) {
                    return false;
                }
                int newState = (oldState) - arg;
                if (compareAndSetState(oldState, newState)) {
                    return newState == 0;
                }
            }
        }

    }

    public static void main(String[] args) throws InterruptedException {
        MayiktCountDownLatch mayiktCountDownLatch=new MayiktCountDownLatch(2);
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName()+":"+1);

            try {
                //当前线程释放锁，当前线程变为阻塞
                mayiktCountDownLatch.await();
            } catch (Exception e) {

            }
            System.out.println(2);

        }).start();
        Thread.sleep(3000);
        System.out.println(3);
        mayiktCountDownLatch.countDown();
       mayiktCountDownLatch.countDown();
        //aqs状态为-1只有aqs状态为0的时候才会唤醒子线程
    }
    }

