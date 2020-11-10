package com.taotao.service.member.api.impl;

import com.taotao.service.member.api.MemberService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

/**
 *@author tom
 *Date  2020/11/10 0010 11:32
 *
 */
@RestController
public class MemberServiceImpl implements MemberService {
 @Value("${server.port}")
 private  String serverport;
    @Override
    public String getUser(Integer userId) {
        return "我是会员服务：userId:"+userId+"端口："+serverport;
    }
}
