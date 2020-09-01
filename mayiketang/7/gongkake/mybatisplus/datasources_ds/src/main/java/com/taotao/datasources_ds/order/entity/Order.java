package com.taotao.datasources_ds.order.entity;

import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author jobob
 * @since 2020-06-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 订单名称
     */
    private String name;

    /**
     * 下单时间
     */
    private LocalDateTime orderCreatetime;

    /**
     * 订单状态 0 已经未支付 1已经支付 2已退单
     */
    private Integer orderState;

    /**
     * 订单价格
     */
    private Double orderMoney;

    /**
     * 商品ID
     */
    private Integer commodityId;


}
