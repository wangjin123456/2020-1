package com.taotao.anhuiquanzi1.ioc.im;

/**
 * @author tom
 * @date 2020/4/9 0009 19:09
 */
public class Bottom {
    private  Tire tire;
    Bottom(int size){
        this.tire=new Tire(size);
    }
}
