package com.mayikt.mtshopservicepay.api.pay.impl;


import com.mayikt.mtshopservicepay.PaymentAggregateService;
import com.mayikt.mtshopservicepay.api.pay.impl.entity.PaymentChannelEntity;
import com.mayikt.mtshopservicepay.api.pay.impl.entity.PaymentTransactionEntity;
import com.mayikt.mtshopservicepay.api.pay.impl.mapper.PaymentChannelMapper;
import com.mayikt.mtshopservicepay.api.pay.impl.mapper.PaymentTransactionMapper;
import com.mayikt.mtshopservicepay.api.pay.impl.strategy.PayStrategy;
import com.mayikt.mtshopservicepay.api.pay.impl.utils.SpringContextUtils;
import com.mayikt.mtshopservicepay.api.pay.impl.utils.TokenUtils;
import com.mayikt.mtshopservicepay.base.BaseApiService;
import com.mayikt.mtshopservicepay.base.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jca.context.SpringContextResourceAdapter;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *@author tom
 *Date  2020/4/21 0021 10:02
 *
 */
@RestController
@Slf4j
public class PaymentAggregateServiceImpl extends BaseApiService  {
    @Autowired
    private PaymentChannelMapper paymentChannelMapper;
    @Autowired
    private TokenUtils tokenUtils;
    @Autowired
    private PaymentTransactionMapper paymentTransactionMapper;
     //localhost:8089/toPayHtml?payToken=pay-c55685e9eaf842038414e89fe9c43f82&channelId=ali_pay
    @GetMapping("/toPayHtml")
    public BaseResponse<String> toPayHtml(String payToken, String channelId) {
        //1, 验证参数
        if(StringUtils.isEmpty(payToken)){
            return  setResultError("payToken不能为空");
        }
        if (StringUtils.isEmpty(channelId)) {
            return setResultError("channelId不能为空!");
        }
        //2  根据渠道id 查询到详细渠道的消息
        PaymentChannelEntity pce=paymentChannelMapper.selectBychannelId(channelId);
         if(pce ==null){
             return  setResultError("该渠道已关闭或不存在，请联系管理员");
         }
         //3 根据 beanid 从Spring容器中找到策略类执行
        String payBeanId=pce.getPayBeanId();
         if(StringUtils.isEmpty(payBeanId)){
             return  setResultError("没有配置payBaenId");
         }
         //4 根据payToken 查询到支付参数内容
         String tokenValue=tokenUtils.getTokenValue(payToken);
         if(StringUtils.isEmpty(tokenValue)){
             return  setResultError("支付已经超时");
         }
         //5 获取我们的预支付的参数信息
        Long payId=Long.parseLong(tokenValue);
         PaymentTransactionEntity ptc=paymentTransactionMapper.selectById(payId);
         if(ptc ==null){
             return  setResultError("请不要攻击我们的服务");
         }
        PayStrategy payStrategy= SpringContextUtils.getBean(payBeanId,PayStrategy.class);
         //6,统一返回html表单给客户端
        String data=payStrategy.toPayHtml(pce,ptc);
         log.info("result:"+data);

        return setResultSuccess(data);
    }
}
