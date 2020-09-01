package com.taotao.metithread;

import java.io.InputStream;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.IntStream;

/**
 *@author tom
 *Date  2020/7/18 0018 21:55
 *基于cas 实现乐观锁
 */
public class AtomicTrylock {
    private AtomicLong atomicLong = new AtomicLong(0);
//设计锁 java  aqs 持有同一把锁,持有人state 为0 没有线程持有锁，获取到锁state为1；

    private Thread lockcutrrentThread;

    /***
     * 获取锁 将内存值改为1
     * @return
     */
    public boolean mayiktTryLock() {
        //v=0 e=0 v==e v=1
        //预期值，更新值
        boolean result = atomicLong.compareAndSet(0, 1);
        if (result) {
            lockcutrrentThread = Thread.currentThread();
        }
        return result;
    }

    /**
     * 释放锁 ji8ang内存值改为0
     * @return
     */
    public boolean mayiktUnlock() {

        if(lockcutrrentThread !=null && lockcutrrentThread !=Thread.currentThread()){
            return  false;
        }
        boolean result = atomicLong.compareAndSet(1, 0);
        return result;

    }

    public static void main(String[] args) {
        AtomicTrylock atomicTrylock =new AtomicTrylock();
        IntStream.range(1,10).forEach((i)-> new Thread(()->{
            try {
                boolean result=atomicTrylock.mayiktTryLock();
                if(result){
                    System.out.println(Thread.currentThread().getName()+",获取锁成功");
                }else {
                    System.out.println(Thread.currentThread().getName()+",或区域锁失败——");
                }
            }catch (Exception e){
                e.printStackTrace();
                atomicTrylock.mayiktUnlock();
            }finally {
                atomicTrylock.mayiktUnlock();
            }
        }).start());

    }
}
