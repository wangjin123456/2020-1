package com.mayikt.mtshopservicepay.api.pay.impl;

import com.mayikt.mtshopservicepay.api.pay.impl.entity.PayOrderTokenDto;
import com.mayikt.mtshopservicepay.base.BaseResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *@author tom
 *Date  2020/4/21 0021 14:39
 *生成预支付提交订单
 */
public interface PayTokenService {
    @PostMapping("/aa")
    String index();
    /**
     *
     * @param payOrderTokenDto
     * @return
     */
    @PostMapping("/toPayToken")
    BaseResponse<String> toPayOrderToken(@RequestBody PayOrderTokenDto payOrderTokenDto);
}
