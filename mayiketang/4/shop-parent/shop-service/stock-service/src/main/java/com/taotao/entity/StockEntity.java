package com.taotao.entity;

import lombok.Data;

/**
 *@author tom
 *Date  2020/5/4 0004 22:02
 *
 */

@Data
public class StockEntity {

    private Long id;
    // 商品id
    private Long commodityId;
    // 库存
    private Long stock;
}
