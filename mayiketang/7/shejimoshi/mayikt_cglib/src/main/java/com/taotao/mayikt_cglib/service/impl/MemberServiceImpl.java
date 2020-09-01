package com.taotao.mayikt_cglib.service.impl;

import com.taotao.mayikt_cglib.service.MemberService;

/**
 *@author tom
 *Date  2020/5/24 0024 12:58
 *
 */
public class MemberServiceImpl implements MemberService {
    @Override
    public String addMember(String userName) {
        System.out.println("........目标方法..........");
        return "meite";
    }

    @Override
    public String addMember1(String userName) {
        System.out.println("........目标方883883883法..........");
        return "m3333eite";
    }
}
