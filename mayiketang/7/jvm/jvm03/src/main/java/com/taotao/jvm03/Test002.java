package com.taotao.jvm03;

import com.taotao.jvm03.service.MayiktService;

import java.util.ServiceLoader;

/**
 *@author tom
 *Date  2020/8/9 0009 7:21
 *SPI机制
 */
public class Test002 {

    public static void main(String[] args) {
        //设置为启动类加载器
        Thread.currentThread().setContextClassLoader(Test002.class.getClassLoader().getParent().getParent());
        //设置为扩展类加载器
        // Thread.currentThread().setContextClassLoader(Test002.class.getClassLoader().getParent());

        ServiceLoader<MayiktService> load = ServiceLoader.load(MayiktService.class);
        System.out.println(Test002.class.getClassLoader());//应用类加载器
        System.out.println(Test002.class.getClassLoader().getParent());//扩展类加载器
        System.out.println(Test002.class.getClassLoader().getParent().getParent());//启动类加载器

        load.forEach((t) -> {
            System.out.println(t);
        });

    }
}
