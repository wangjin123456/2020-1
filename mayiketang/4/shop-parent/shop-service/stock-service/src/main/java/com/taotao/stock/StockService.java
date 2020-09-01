package com.taotao.stock;

import com.taotao.base.ResponseBase;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *@author tom
 *Date  2020/5/4 0004 22:03
 *
 */

public interface StockService {

    // 根据商品id 减库存数量
    @RequestMapping("/inventoryReduction")
    public ResponseBase inventoryReduction(@RequestParam("commodityId") Long commodityId);

}

