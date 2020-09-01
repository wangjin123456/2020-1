package com.taotao.mapper;

import com.taotao.entity.OrderEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;

/**
 *@author tom
 *Date  2020/5/4 0004 22:10
 *
 */
public interface OrderMapper {

    @Insert(value = "INSERT INTO `order` VALUES (#{id}, #{name}, #{orderCreatetime}, #{orderState}, #{orderMoney}, #{commodityId})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    public int addOrder(OrderEntity orderEntity);
}
