package com.itmayiedu.api.member.impl;
import com.alibaba.dubbo.config.annotation.Service;

import com.itmayiedu.api.member.IMemberService;
import org.springframework.beans.factory.annotation.Value;


/**
 *@author tom
 *Date  2020/5/2 0002 21:07
 *
 */
@Service
public class  MemberServiceImpl  implements IMemberService {
    @Value("${server.port}")
    private String serverport;
    @Override
    public String getUser() {
        return "订单服务调用会员服务,端口号："+serverport;
    }
}
