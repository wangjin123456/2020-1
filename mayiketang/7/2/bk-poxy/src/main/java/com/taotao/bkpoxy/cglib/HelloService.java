package com.taotao.bkpoxy.cglib;

/**
 *@author tom
 *Date  2020/7/6 0006 7:00
 *实现一个业务类，没有实现任何接口
 */
public class HelloService {

    public HelloService() {
        System.out.println("HelloService构造");
    }

    /**
     * 该方法不被子类覆盖，cglib是无法代理final 修饰方法的
     * @param name
     * @return
     */
    final public String asyothers(String  name){
        System.out.println("Helloservice: sayothers>>"+name);
        return  null;
    }

    public void sayHello(){
        System.out.println("HellowService: sayHello");
    }



}
