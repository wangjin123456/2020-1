package com.mayikt.mtshopservicepay.api.pay.impl;

import com.mayikt.mtshopservicepay.base.BaseResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *@author tom
 *Date  2020/4/21 0021 9:40
 *
 */
@RestController
public interface PayInfoService {
    @RequestMapping("/addPay")
    BaseResponse<String> addPay(Long price);
}
