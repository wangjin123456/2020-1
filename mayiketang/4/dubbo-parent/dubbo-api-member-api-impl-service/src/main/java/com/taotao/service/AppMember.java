package com.taotao.service;


import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 *@author tom
 *Date  2020/5/1 0001 9:41
 *xml方式启动
 */
public class AppMember {
    public static void main(String[] args) throws IOException {
       /* ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("consumer.xml");
        context.start();
        System.out.println("consumer start");
        IndexService demoApiService = context.getBean(IndexService.class);
        String result = demoApiService.index();
        System.out.println("result:" + result);*/
        //加载xml配置文件启动
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("consumer.xml");
        context.start();
        System.in.read(); // 按任意键退出
    }
}
