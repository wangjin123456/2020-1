package com.taotao.lamba;

import com.taotao.lamba.service.MemberService;
import com.taotao.lamba.service.OrderServie;
import com.taotao.lamba.service.impl.OrderServiceImpl;

/**
 *@author tom
 *Date  2020/6/3 0003 20:50
 *
 */
public class Test001 {
    public static void main(String[] args) {
       // OrderServie orderServie=new OrderServiceImpl();
    //    orderServie.addOrder();
        new OrderServie() {
            @Override
            public void addOrder() {
                System.out.println("使用匿名内部类的形式调用接口");
            }
        }.addOrder();
       //3, 使用lambda 调用接口
        OrderServie orderServie2= ()->
                System.out.println("使用lambda调用接口");
          orderServie2.addOrder();
          //lamdba表达式语法带参数有返回值
        MemberService memberService=(String userName,Integer age) ->{
            System.out.println("有参数返回值");
            return  userName+ ","+age;
        };
        String result=memberService.addMember("mayikt",22);
        System.out.println(result);
    }
}
