package com.taotao.picecharts.lock;

/**
 *@author tom
 *Date  2020/10/21 0021 8:08
 *
 */
public abstract class AbstractTemplateLock implements  Lock {
    protected abstract void waitLock();

    protected abstract boolean tryLock();

    protected abstract void releaseLock();
    @Override
    public void getLock() throws Exception {
        if(tryLock()){
            System.out.println(Thread.currentThread().getName()+"获取锁成功");
        }else {
            //等待
            waitLock();//事件监听，如果节点被删除则可以重新获取
            //重新获取
            getLock();
        }
    }

    @Override
    public void unlock() throws Exception {
        System.out.println(21);
 releaseLock();
    }
}
