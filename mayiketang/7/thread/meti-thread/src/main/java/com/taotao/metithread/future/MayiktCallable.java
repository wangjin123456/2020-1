package com.taotao.metithread.future;

/**
 *@author tom
 *Date  2020/7/31 0031 9:22
 *定义call方法
 */
public interface MayiktCallable <V>{
    V call() throws Exception;
}
