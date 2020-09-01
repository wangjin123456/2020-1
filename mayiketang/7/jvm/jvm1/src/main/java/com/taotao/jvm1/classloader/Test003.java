package com.taotao.jvm1.classloader;

import java.util.Arrays;
import java.util.List;

/**
 *@author tom
 *Date  2020/8/6 0006 9:53
 *
 */
public class Test003 {
    public static void main(String[] args) {
         //   bootstrapClassLoader();
       // extClassLoader();
        appClassLoader();

    }

    //启动类加载器
    private static void bootstrapClassLoader() {
        String property=System.getProperty("sun.boot.class.path");
        List<String> list= Arrays.asList(property.split(";"));
        list.forEach((t)->{
            System.out.println("启动类加载器目录："+t);
        });


    }


    //扩展类加载器
    public  static  void extClassLoader(){
        String property=System.getProperty("java.ext.dirs");
        List<String> list=Arrays.asList(property.split(";"));
        list.forEach((t)->{
            System.out.println("扩展类加载器"+t);
        });
    }
    //类加载器
    public  static  void appClassLoader(){
        String property=System.getProperty("java.class.path");
        List<String> list=Arrays.asList(property.split(";"));
        list.forEach((t)->{
            System.out.println("应用类加载器"+t);
        });
    }
}
