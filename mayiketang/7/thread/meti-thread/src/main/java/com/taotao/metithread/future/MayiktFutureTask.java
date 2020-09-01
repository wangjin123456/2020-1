package com.taotao.metithread.future;

import java.util.concurrent.locks.LockSupport;

/**
 *@author tom
 *Date  2020/7/31 0031 9:26
交给线程运行 实现Runnable
调用call接口
 */
public class MayiktFutureTask<V> implements Runnable {
    private MayiktCallable<V> mayiktMTallabke;
    //callable对应的返回结果
    private V result;
private Thread cuthread;
    public MayiktFutureTask(MayiktCallable<V> mayiktMTallabke) {
        this.mayiktMTallabke = mayiktMTallabke;
    }

    @Override
    public void run() {
        //执行我们的call
        if (mayiktMTallabke != null) {
            try {
                result = mayiktMTallabke.call();
                //唤醒阻塞的线程
                LockSupport.unpark(cuthread);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public V get() {
        //如果callable方法返回空的时候，则会变阻塞状态
        if (result != null) {
            return result;
        }
        //让当前
        // 线程变为阻塞
        cuthread =new Thread();
        LockSupport.park(cuthread);
        return result;
    }
}
