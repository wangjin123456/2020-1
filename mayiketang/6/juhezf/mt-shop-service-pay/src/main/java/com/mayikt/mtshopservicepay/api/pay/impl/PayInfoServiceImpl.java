package com.mayikt.mtshopservicepay.api.pay.impl;

import com.mayikt.mtshopservicepay.base.BaseApiService;
import com.mayikt.mtshopservicepay.base.BaseResponse;
import com.mayikt.mtshopservicepay.sign.SignUtil;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 *@author tom
 *Date  2020/4/21 0021 9:39
 *
 */
@RestController
public class PayInfoServiceImpl  extends BaseApiService implements  PayInfoService {
    @Override
    public BaseResponse<String> addPay(Long price) {
        if(price ==null){
            return  setResultError("价格不能为空");
        }
        HttpServletRequest request =((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
           //验签参数处理
        Map<String,String> verifyMap= SignUtil.toVerifyMap(request.getParameterMap(),false);
        //验签
        if(!SignUtil.verify(verifyMap)){
            return  setResultError("签名失败，参数可能发生了变化");
        }


        return setResultError("price:"+price);
    }
}
