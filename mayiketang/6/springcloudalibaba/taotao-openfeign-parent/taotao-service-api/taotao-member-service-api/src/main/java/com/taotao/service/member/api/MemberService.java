package com.taotao.service.member.api;

import org.springframework.web.bind.annotation.GetMapping;

/**
 *@author tom
 *Date  2020/11/10 0010 11:23
 *
 */
public interface MemberService {
    /**
     * 提供发布的接口
     * @param userId
     * @return
     */
    @GetMapping("/getUser")
    String getUser(Integer userId);
}
