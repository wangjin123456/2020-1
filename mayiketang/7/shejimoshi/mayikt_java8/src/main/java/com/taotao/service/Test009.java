package com.taotao.service;

/**
 *@author tom
 *Date  2020/6/19 0019 9:17
 *
 */
public class Test009 {
    /**
     * 如何定义一个接口函数
     */

    public static void main(String[] args) {
       // PayService payService=(money)-> System.out.println(money);
      //  PayService payService=(money)->toPay(money);
        //方法引入 方法隶属::方法名称即可
        PayService payService=new Test009()::toPay1;
        payService.toPay(10);
    }
     public  void toPay1(Long money){
         System.out.println(money);
     }

    /***
     * 方法引入的规范，方法名称的和函数接口参数类型一致
     */
}
