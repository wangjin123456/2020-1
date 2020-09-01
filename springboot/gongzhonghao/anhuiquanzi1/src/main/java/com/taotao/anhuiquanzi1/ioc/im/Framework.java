package com.taotao.anhuiquanzi1.ioc.im;

/**
 * @author tom
 * @date 2020/4/9 0009 19:10
 */
public class Framework {
    private  Bottom bottom;
    Framework(int size){
        this.bottom=new Bottom(size);
    }
}
