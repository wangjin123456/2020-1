package com.taotao.api.stock.impl;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.taotao.base.BaseApiService;
import com.taotao.base.ResponseBase;

import com.taotao.entity.StockEntity;
import com.taotao.mapper.StockMapper;

import com.taotao.stock.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *@author tom
 *Date  2020/5/4 0004 22:37
 *
 */
@RestController
public class StockServiceImpl  extends BaseApiService implements StockService {
    @Autowired
    private StockMapper stockMapper;
    @Override
    @Transactional
    @LcnTransaction
    @RequestMapping("/inventoryReduction")
    public ResponseBase inventoryReduction(@RequestParam("commodityId") Long commodityId) {
        if (commodityId == null) {
            return setResultError("商品id不能为空!");
        }
        // 1.查询该商品id 是否存在
        StockEntity stockEntity = stockMapper.selectStock(commodityId);
        if (stockEntity == null) {
            return setResultError("商品id不存在!");
        }
        if(stockEntity.getStock()<=0){
            return  setResultError("当前商品已经卖完");
        }

        // 3.减去库存1
        int updateStockResult = stockMapper.updateStock(commodityId);
        if (updateStockResult <= 0) {
            return setResultError("修改库存失败!");
        }
        return setResultSuccess("修改库存成功!");
    }
}
