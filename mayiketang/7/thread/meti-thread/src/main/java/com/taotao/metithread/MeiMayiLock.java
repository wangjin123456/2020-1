package com.taotao.metithread;

import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

/**
 *@author tom
 *Date  2020/7/23 0023 9:27
 *
 */
public class MeiMayiLock {
    /**
     * 获取锁 0表示当前线程没有获取锁 1表示获取到锁
     */
    //  private   volatile  int state;
    AtomicInteger atomicstate = new AtomicInteger(0);
    //存放没有获取到锁的线程
    private ConcurrentLinkedDeque<Thread> waitThreads = new ConcurrentLinkedDeque<>();

    //记录锁被哪个线程持有
    private transient Thread exclusiveOwnerThread;

    //获取锁
    public void lock() {
        //e=0,n=1,v=0
        if (compareAndState(0, 1)) {
            //当前线程持有锁
            setExclusiveOwnerThread(Thread.currentThread());
        } else {
            //使用cas参数修改锁的状态,设计重试次数
            Thread thread = Thread.currentThread();
            waitThreads.add(thread);
            for (; ; ) {
                if (acquire()) {
                    return;
                }
                //重试一次还是没有获取锁，将当期这个线程变为阻塞状态
                LockSupport.park();
            }
        }
    }

    //释放锁
    public void unlock() {
        if (exclusiveOwnerThread != Thread.currentThread()) {
            throw new RuntimeException("不是当前锁，释放锁线程");
        }
        //释放锁
        if (compareAndState(1, 0)) {
            this.exclusiveOwnerThread=null;
            //取出阻塞的线程重新获取锁
            Thread pollthread=waitThreads.poll();
            //唤醒刚才阻塞的线程
            if(pollthread!=null){
                LockSupport.unpark(pollthread);
            }

        }
    }

    /**
     * cas三个参数  V E N
     * @param expect
     * @param update
     * @return
     */
    private boolean compareAndState(int expect, int update) {
        return atomicstate.compareAndSet(expect, update);
    }

    public void setExclusiveOwnerThread(Thread exclusiveOwnerThread) {
        this.exclusiveOwnerThread = exclusiveOwnerThread;
    }

    //修改锁的状态
    private boolean acquire() {
        //当前线程获得锁
        if (compareAndState(0, 1)) {
            setExclusiveOwnerThread(Thread.currentThread());
            return true;
        }
        return false;
    }
}
