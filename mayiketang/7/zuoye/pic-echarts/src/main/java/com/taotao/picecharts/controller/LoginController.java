package com.taotao.picecharts.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *@author tom
 *Date  2020/10/21 0021 7:24
 *
 */
@RestController
public class LoginController {
    @GetMapping("login")
    public String login() {
        //登录逻辑
        return "success";
    }
}
