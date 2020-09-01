package com.mayikt.mtshopservicepay.api.pay.impl.mapper;

import com.mayikt.mtshopservicepay.api.pay.impl.entity.PaymentTransactionEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 *@author tom
 *Date  2020/4/21 0021 9:18
 *
 */
public interface PaymentTransactionMapper {
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("INSERT INTO `payment_transaction` VALUES (null, #{payAmount}, '0', #{userId}, #{orderId}, null, null, now(), null, now(),null,#{paymentId},null,#{orderName});")
    public int insertPaymentTransaction(PaymentTransactionEntity paymentTransactionEntity);

    @Select("SELECT ID AS ID ,pay_Amount AS payAmount,payment_Status AS paymentStatus,user_ID AS userId, order_Id AS orderId ," +
            " created_Time as createdTime ,partypay_Id as partyPayId , payment_Id as paymentId ,payment_channel as paymentChannel ,order_name as orderName FROM payment_transaction WHERE ID=#{id};")
    public PaymentTransactionEntity selectById(Long id);

    @Select("SELECT ID AS ID ,pay_Amount AS payAmount,payment_Status AS paymentStatus,user_ID AS userId, order_Id AS orderId , created_Time as createdTime ,partypay_Id as partyPayId , payment_Id as paymentId ,payment_channel as paymentChannel FROM payment_transaction WHERE PAYMENT_ID=#{paymentId};")
    public PaymentTransactionEntity selectByPaymentId(String paymentId);

    @Update("update payment_transaction SET PAYMENT_STATUS=#{paymentStatus},payment_channel=#{paymentChannel}   WHERE PAYMENT_ID=#{paymentId}; ")
    public int updatePaymentStatus(@Param("paymentStatus") String paymentStatus, @Param("paymentId") String paymentId,
                                   @Param("paymentChannel") String paymentChannel);

    @Select("SELECT ID AS ID ,pay_Amount AS payAmount,payment_Status AS paymentStatus,user_ID AS userId, order_Id AS orderId , created_Time as createdTime ,partypay_Id as partyPayId , payment_Id as paymentId ,payment_channel as paymentChannel FROM payment_transaction WHERE PAYMENT_ID=#{paymentId} and paymentStatus=0 ;")
    public PaymentTransactionEntity selectByPaymentNoPayment(String paymentId);

    @Select("SELECT ID AS ID ,pay_Amount AS payAmount,payment_Status AS paymentStatus,user_ID AS userId, order_Id AS orderId , created_Time as createdTime ,partypay_Id as partyPayId , payment_Id as paymentId ,payment_channel as paymentChannel FROM payment_transaction WHERE paymentStatus=0 ;")
    public List<PaymentTransactionEntity> selectByStatusStay();
}
