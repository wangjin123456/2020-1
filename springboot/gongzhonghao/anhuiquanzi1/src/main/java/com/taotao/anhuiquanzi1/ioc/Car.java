package com.taotao.anhuiquanzi1.ioc;

/**
 * @author tom
 * @date 2020/4/9 0009 19:02
 */
public class Car {
    private  Framework framework;

    public Car(Framework framework) {
        System.out.println("kaiqi ");
        this.framework = framework;
    }

    public static void main(String[] args) {
        int size=40;
        Tire tire=new Tire(size);
        Bottom bottom=new Bottom(tire);
        Framework framework=new Framework(bottom);
        Car car =new Car(framework);
    }
}
