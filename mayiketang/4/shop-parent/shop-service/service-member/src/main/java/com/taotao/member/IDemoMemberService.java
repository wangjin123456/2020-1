package com.taotao.member;

import com.taotao.base.ResponseBase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *@author tom
 *Date  2020/5/4 0004 21:49
 *
 */
public interface IDemoMemberService {

    @GetMapping("/demoMember")
    public ResponseBase demoMember(@RequestParam("userId") Long userId);

}


