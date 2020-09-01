package com.taotao.lamba;

import com.taotao.lamba.service.MemberService;
import com.taotao.lamba.service.PayService;

/**
 *@author tom
 *Date  2020/6/4 0004 9:12
 *
 */
public class Test003 {
    public static void main(String[] args) {
        //1,在 lambda表达式中可以直接省略参数类型
        MemberService memberService = (a, b) -> {
            System.out.println("有参数有返回值");
            return a + "," + b;
        };
        String result = memberService.addMember("mayikt", 22);
        System.out.println(result);
        //2 参数列表中只有一个参数的情况下，可以注解省略（）
        PayService payService1 = (a) -> {
            System.out.println("支付接口" + a);
        };
        payService1.toPay(10L);
        //如果大括号里只有一条执行语句的情况下，可以直接省略{}
        PayService payService2 = (a) -> System.out.println("支付接口");
        payService2.toPay(10L);
        //如果代码里只有一条执行return,可以省略{}
        MemberService memberService1=(a,b) -> a+","+b;
        String result1 = memberService1.addMember("mayikt", 22);
        System.out.println(result1);
    }
}
