package com.mayikt.mtshopservicepay.api.pay.impl.utils;

/**
 *@author tom
 *Date  2020/4/21 0021 15:08
 *使用雪花算法生成全局id
 */
public class SnowflakeIdUtils {
    private static  SnowflakeIdWorker idWorker;
    static {
        //使用静态代码块初始化SnowflakeIdWorker
        idWorker =new SnowflakeIdWorker(1,1);
    }
    public  static String nextId(){
        return  idWorker.nextId()+"";
    }
}
