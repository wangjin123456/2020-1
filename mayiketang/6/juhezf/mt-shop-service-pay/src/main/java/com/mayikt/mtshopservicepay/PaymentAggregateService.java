package com.mayikt.mtshopservicepay;

import com.mayikt.mtshopservicepay.base.BaseResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *@author tom
 *Date  2020/4/21 0021 10:25
 *
 */
public interface PaymentAggregateService {

@GetMapping("/toPayHtml")
    BaseResponse<String> toPayHtml(@RequestParam("payToken")String payToken,
                                   @RequestParam("channelId")String channelId);

}
