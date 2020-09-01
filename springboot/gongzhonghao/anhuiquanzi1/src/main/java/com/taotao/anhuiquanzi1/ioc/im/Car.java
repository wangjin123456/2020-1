package com.taotao.anhuiquanzi1.ioc.im;

/**
 * @author tom
 * @date 2020/4/9 0009 19:11
 */
public class Car {
    private  Framework framework;
    Car(int size){
        this.framework=new Framework(size);
    }

    public static void main(String[] args) {
        int size=90;
         Car car=new Car(size);

    }
}
