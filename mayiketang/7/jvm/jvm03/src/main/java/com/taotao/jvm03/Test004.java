package com.taotao.jvm03;

import com.taotao.jvm03.service.OrderService;

import java.io.File;

/**
 *@author tom
 *Date  2020/8/9 0009 9:17
 *
 */
public class Test004 {
    private static long startTime;

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        MayiktClassLoader mayiktClassLoader = new MayiktClassLoader();
        mayiktClassLoader.setFileObject(new File("D:\\code\\OrderServiceImpl.class"));
        Class<?> aClass = mayiktClassLoader.findClass("com.taotao.jvm03.service.impl.OrderServiceImpl");
        OrderService orderService = (OrderService) aClass.newInstance();
        System.out.println("读取class成功：" + orderService.Order());

        File fileObject = mayiktClassLoader.getFileObject();
        startTime = fileObject.lastModified();
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(2000);
                } catch (Exception e) {

                }
                long endTime = fileObject.lastModified();
                if (endTime != startTime) {

                    System.out.println("class文件发生了变化，需要重新读取");
                    try {
                        MayiktClassLoader newMayiktClassLoader = new MayiktClassLoader();
                        newMayiktClassLoader.setFileObject(new File("D:\\code\\OrderServiceImpl.class"));
                        Class<?> newClass = newMayiktClassLoader.findClass("com.taotao.jvm03.service.impl.OrderServiceImpl");
                        OrderService newOrderService = (OrderService) newClass.newInstance();
                        System.out.println("读取class成功：" + newOrderService.Order());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    startTime = endTime;
                }
            }
        }).start();
    }
}