package com.taotao.mglib;

import com.taotao.mglib.cglib.CglibMethoodinterceptor;
import com.taotao.mglib.service.MemberServiceImpl$$EnhancerByCGLIB$$c4787b92;
import com.taotao.mglib.service.impl.MemberServiceImpl;
import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;

/**
 *@author tom
 *Date  2020/7/6 0006 9:27
 *
 */
public class Test001 {
    public static void main(String[] args) {
        // 代理类class文件存入本地磁盘方便我们反编译查看源码
     //   System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:\\code");

    /*    System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY,"D:\\code");
        Enhancer enhancer=new Enhancer();

        enhancer.setSuperclass(MemberServiceImpl.class);
        enhancer.setCallback(new CglibMethoodinterceptor());
        //创建代理对象
        MemberServiceImpl memberService=(MemberServiceImpl) enhancer.create();
         memberService.addMember("33");*/
        MemberServiceImpl$$EnhancerByCGLIB$$c4787b92 memberServiceImpl
                =new MemberServiceImpl$$EnhancerByCGLIB$$c4787b92();
        memberServiceImpl.addMember("33");

    }


}
