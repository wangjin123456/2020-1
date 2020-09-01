package com.itmayidu.api.service.feign;


import com.itmayidu.api.service.IMemberService;
import com.itmayidu.api.service.fallback.MemberServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;

/**
 *@author tom
 *Date  2020/4/21 0021 23:59
 *
 */
@FeignClient(value = "app-itmayiedu-member",fallback = MemberServiceFallback.class)
public interface MemberServiceFeign  extends IMemberService {

}
