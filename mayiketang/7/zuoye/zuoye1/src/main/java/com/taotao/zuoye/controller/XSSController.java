package com.taotao.zuoye.controller;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *@author tom
 *Date  2020/7/14 0014 8:53
 *
 */
@RestController
public class XSSController {

    @RequestMapping("/getUserInfo")
    public String getUserInfo(String UserName) {
        UserName = DigestUtils.md5Hex(UserName);
        System.out.println(UserName);
        return UserName;
    }
}
