package com.taotao.mt_autu_server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *@author tom
 *Date  2020/6/18 0018 18:49
 *
 */
@RestController
public class MemberService {
    @GetMapping("/getMember")
    public String getMember() {
        return "我是会员服务接口";
    }
}
