package com.taotao.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *@author tom
 *Date  2020/11/9 0009 13:18
 *
 */
@RestController
public class MemberService {
    @Value("${server.port}")
    private  String serverport;
    /**
     * 会员服务提供的接口被订单服务调用
     * @ret
     * urn
     */
    @RequestMapping("/getUser")
    public  String getUser(Integer userId){
        return  "the world is  good,端口号为，"+serverport+"userId="+userId ;
    }
}
