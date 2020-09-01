package com.itmayidu.api.service;

import com.itmayidu.api.entity.UserEntity;

import com.taotao.ResponseBase;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *@author tom
 *Date  2020/4/21 0021 18:46
 *
 */

public interface IMemberService {
    /**
     *接口类
     * @param name
     * @return
     */
    @RequestMapping("/getMember")
    public UserEntity getMember(@RequestParam(value = "name") String name);
    @RequestMapping("/getUserInfo")
    public ResponseBase getUserInfo() throws InterruptedException;

}
