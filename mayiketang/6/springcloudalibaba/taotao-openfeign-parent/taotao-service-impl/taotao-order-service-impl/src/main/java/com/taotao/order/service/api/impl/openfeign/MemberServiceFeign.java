package com.taotao.order.service.api.impl.openfeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *@author tom
 *Date  2020/11/10 0010 11:48
 *
 */
@FeignClient("taotao-member")
public interface MemberServiceFeign {
    @GetMapping("/getUser")
    String getUser(@RequestParam("userId") Integer userId);
}
