package com.mayikt.mtshopservicepay.api.pay.impl;

import com.mayikt.mtshopservicepay.api.pay.impl.entity.PayOrderTokenDto;
import com.mayikt.mtshopservicepay.api.pay.impl.entity.PaymentTransactionEntity;
import com.mayikt.mtshopservicepay.api.pay.impl.mapper.PaymentTransactionMapper;
import com.mayikt.mtshopservicepay.api.pay.impl.utils.SnowflakeIdUtils;
import com.mayikt.mtshopservicepay.api.pay.impl.utils.TokenUtils;
import com.mayikt.mtshopservicepay.base.BaseApiService;
import com.mayikt.mtshopservicepay.base.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *@author tom
 *Date  2020/4/21 0021 14:36
 *
 */
@RestController
public class PayTokenServiceImpl extends BaseApiService {
    @Autowired
    private PaymentTransactionMapper paymentTransactionMapper;
    @Autowired
    private TokenUtils tokenUtils;


      @PostMapping("/toPayOrderToken")
    public BaseResponse<String> toPayOrderToken(PayOrderTokenDto payOrderTokenDto) {
        //验证参数
        String orderId = payOrderTokenDto.getOrderId();
        if (StringUtils.isEmpty(orderId)) {
            return setResultError("订单号码不能为空!");
        }
        Long payAmount = payOrderTokenDto.getPayAmount();
        if (payAmount == null) {
            return setResultError("金额不能为空");
        }
        Long userId = payOrderTokenDto.getUserId();
        if (userId == null) {
            return setResultError("userId不能为空");
        }

        String orderName = payOrderTokenDto.getOrderName();
        if (orderName == null) {
            return setResultError("orderName不能为空");
        }
        //2 生成支付的全局id
        PaymentTransactionEntity paymentTransactionEntity = dtoToDo(payOrderTokenDto, PaymentTransactionEntity.class);

        //3,支付详细表插入一条记录
        paymentTransactionEntity.setPaymentId(SnowflakeIdUtils.nextId() + "");
        int result = paymentTransactionMapper.insertPaymentTransaction(paymentTransactionEntity);
        if (result <= 0) {
            return setResultError("系统错误");
        }
        Long payId = paymentTransactionEntity.getId();
        if (payId == null) {
            return setResultError("系统错误");
        }
         //4,生成token令牌
        String payToken=tokenUtils.createToken("mayikt:pay",payId+"");
        if(StringUtils.isEmpty(payToken)){
            return  setResultError("生成支付令牌失败");
        }
        return setResultSuccess(payToken);
    }
}
