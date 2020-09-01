package com.taotao.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 *@author tom
 *Date  2020/6/1 0001 0:11
 *
 */
@Component
public class SpringUtils  implements ApplicationContextAware {
    private static  ApplicationContext applicationContext;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }



    //获取applicationContext
    public static  ApplicationContext getApplicationContext(){
        return  applicationContext;
    }
    //通过name获取bean
    public  static  Object getBean(String name){
         return  getApplicationContext().getBean(name);
    }
    //通过class获取bean
    public  static <T> T getBean(Class<T> tClass){
        return  getApplicationContext().getBean(tClass);
    }
    //通过name,以及class返回指定的bean
    public  static  <T> T getBean(String name,Class<T> tClass){
        return  getApplicationContext().getBean(name,tClass);
    }

}
