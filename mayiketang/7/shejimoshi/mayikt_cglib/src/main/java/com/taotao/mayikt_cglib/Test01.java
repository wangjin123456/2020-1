package com.taotao.mayikt_cglib;

import com.taotao.mayikt_cglib.service.MemberService;
import com.taotao.mayikt_cglib.service.cglib.CglibMethodInterceptor;
import com.taotao.mayikt_cglib.service.impl.MemberServiceImpl;
import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;

/**
 *@author tom
 *Date  2020/5/24 0024 21:45
 *
 */
public class Test01 {
    public static void main(String[] args) {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY,"D:\\code");//将动态代理类写入到本地
        Enhancer enhancer =new Enhancer();

        enhancer.setSuperclass(MemberServiceImpl.class);
        enhancer.setCallback(new CglibMethodInterceptor());
        //创建代理对象
        MemberService memberService= (MemberService) enhancer.create();
        memberService.addMember("mayikt");
    }
}
