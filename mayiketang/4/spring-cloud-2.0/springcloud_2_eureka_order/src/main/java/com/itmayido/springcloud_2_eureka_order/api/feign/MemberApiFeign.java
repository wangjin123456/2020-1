package com.itmayido.springcloud_2_eureka_order.api.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *@author tom
 *Date  2020/4/20 0020 19:16
 *
 */
@FeignClient(name = "APP-ITMAYIDU-MEMBER")
public interface MemberApiFeign {
    @RequestMapping("/getMember")
    public  String getMember();
}
