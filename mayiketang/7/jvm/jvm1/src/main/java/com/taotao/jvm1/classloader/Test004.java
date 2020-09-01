package com.taotao.jvm1.classloader;

import java.io.File;

/**
 *@author tom
 *Date  2020/8/8 0008 8:46
 *自定义热部署功能
 */
public class Test004 {

    private static long startTime;

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        MayiktClassLoader mayiktClassLoader = new MayiktClassLoader();
        mayiktClassLoader.setFileObject(new File("F:\\works\\2020\\mayiketang\\7\\jvm\\jvm1\\target\\classes\\com\\taotao\\jvm1\\classloader\\OrderServiceImpl.class"));
        Class<?> aClass = mayiktClassLoader.findClass("com.taotao.jvm1.classloader.OrderServiceImpl");
        OrderService orderService = (OrderService) aClass.newInstance();
        System.out.println("读取class：" + orderService.addOrder());
       File fileObject=mayiktClassLoader.getFileObject();
       startTime=fileObject.lastModified();
       new Thread(()->{
           while (true){
               try {
                   Thread.sleep(2000);
               }catch (Exception e){
                   e.printStackTrace();
               }
               long endTime=fileObject.lastModified();
               if(endTime !=startTime){
                   System.out.println("class文件发生了变化，需要重新读取");
                   try {
                       MayiktClassLoader newMayiktClassLoader=new MayiktClassLoader();
                       newMayiktClassLoader.setFileObject(new File(""));
                       Class<?> newClass = newMayiktClassLoader.findClass("com.taotao.jvm1.classloader.OrderServiceImpl");
                       OrderService newOrderService = (OrderService) newClass.newInstance();
                       System.out.println("读取class成功：" + newOrderService.addOrder());
                   } catch (IllegalAccessException e) {
                       e.printStackTrace();
                   } catch (InstantiationException e) {
                       e.printStackTrace();
                   } catch (ClassNotFoundException e) {
                       e.printStackTrace();
                   }

               }
           }
       }).start();

    }


}
