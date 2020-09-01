package com.mayikt.mtshopservicepay.api.pay.impl.mapper;

import com.mayikt.mtshopservicepay.api.pay.impl.entity.PaymentChannelEntity;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 *@author tom
 *Date  2020/4/21 0021 0:38
 *
 */
public interface PaymentChannelMapper {
    @Select("SELECT channel_Name  AS channelName , channel_Id AS" +
            " channelId, merchant_Id AS merchantId,sync_Url AS syncUrl, asyn_Url AS asynUrl,public_Key " +
            "AS publicKey, private_Key AS privateKey,channel_State AS channelState , " +
            "pay_bean_id as paybeanid ,request_Address as requestAddress    FROM payment_channel WHERE CHANNEL_STATE='0';")
    public List<PaymentChannelEntity> selectAll();


    @Select("SELECT channel_Name  AS channelName , channel_Id AS channelId, merchant_Id AS merchantId,sync_Url AS syncUrl, asyn_Url AS asynUrl,public_Key AS publicKey, private_Key AS privateKey,channel_State AS channelState ," +
            "  pay_bean_id as payBeanId  ,request_Address as requestAddress   FROM payment_channel WHERE CHANNEL_STATE='0'  AND channel_Id=#{channelId} ;")
    PaymentChannelEntity selectBychannelId(String channelId);
}
