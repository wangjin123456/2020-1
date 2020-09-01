package com.taotao.lamba;

import com.taotao.lamba.service.PayService;

/**
 *@author tom
 *Date  2020/6/4 0004 9:28
 *
 */
public class Test005 {
    /**
     * 1.在接口中只能允许有一个抽象方法
     * 2 @FunctionlInterface
     * 3 在通过default 修饰为普通方法
     * 4 可以定义object 的方法
     */
    public static void main(String[] args) {
        PayService payService1= (a) -> System.out.println(a+"支付项目");

        payService1.toPay(10L);
         PayService payService2=(a) ->pay(10L);
         payService2.toPay(10L);
         //方法的引入 隶属方法的引用：；方法的名称
        PayService payService3=Test005::pay;
        payService3.toPay(10);
    }

    private static void pay(long money) {
        System.out.println("支付金额："+money);
    }


}
