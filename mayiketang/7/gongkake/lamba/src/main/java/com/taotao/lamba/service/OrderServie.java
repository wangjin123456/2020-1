package com.taotao.lamba.service;

/**
 *@author tom
 *Date  2020/6/3 0003 20:44
 *
 */
public interface OrderServie {
    /**
     * 抽象方法
     */
    void  addOrder();

    /**
     *普通方法
     * 新特性
     */
       default void getOrder(){
        System.out.println("使用java新特性");
    }


}
