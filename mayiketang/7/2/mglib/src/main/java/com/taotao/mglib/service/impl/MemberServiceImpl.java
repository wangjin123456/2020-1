package com.taotao.mglib.service.impl;

import com.taotao.mglib.service.MemberService;

/**
 *@author tom
 *Date  2020/7/6 0006 9:03
 *
 */
public class MemberServiceImpl  implements MemberService {
    @Override
    public String addMember(String userName) {
        System.out.println("...目标方法..");
        return userName;
    }
}
