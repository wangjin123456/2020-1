package com.itmayido.springcloud_2_eureka_order.api.controller;

import com.itmayido.springcloud_2_eureka_order.api.feign.MemberApiFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *@author tom
 *Date  2020/4/20 0020 19:32
 *
 */
@RestController
@RequestMapping("/feign")
public class FeignController {
    @Autowired
    private MemberApiFeign feign;

    @RequestMapping("/getMember")
    public String getMember() {
    return feign.getMember();
    }

}
