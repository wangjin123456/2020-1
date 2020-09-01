package com.taotao.metithread;
import  org.openjdk.jol.info.ClassLayout;
/**
 *@author tom
 *Date  2020/7/20 0020 9:21
 *查看类型占的字节情况
 */
public class MeiteLock {
    private  int userId;

    public static void main(String[] args) {
        MeiteLock meiteLock=new MeiteLock();
        System.out.println(meiteLock.hashCode());
        System.out.println(Integer.toHexString(meiteLock.hashCode()));
        System.out.println(ClassLayout.parseInstance(meiteLock).toPrintable());
    }
}
