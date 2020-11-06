package com.taotao.picecharts.lock;

/**
 *@author tom
 *Date  2020/10/21 0021 8:05
 *
 */
public interface Lock {

    /**
     * 获取锁
     */
    void getLock() throws Exception;
    /**
     * 释放锁
     */

    void unlock() throws  Exception;
}
