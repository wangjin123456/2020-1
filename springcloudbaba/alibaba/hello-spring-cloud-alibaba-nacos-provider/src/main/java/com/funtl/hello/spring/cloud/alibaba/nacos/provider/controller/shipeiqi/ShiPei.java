package com.funtl.hello.spring.cloud.alibaba.nacos.provider.controller.shipeiqi;

import org.springframework.beans.factory.annotation.Autowired;

public class ShiPei {
    public static void main(String[] args) {
        ShiPei shiPei=new ShiPei();
             

    }


    interface Animal{
        public  void sing();
        public  void cry();
        public  void run();
        public  void swim();
    }
    class Dog extends  AnimalFunction{
        @Override
        public void run() {
            System.out.println("跑步");
        }
    }
    //适配器类
    abstract  class AnimalFunction{

        public void sing() {

        }


        public void cry() {

        }


        public void run() {

        }


        public void swim() {

        }
    }
}
