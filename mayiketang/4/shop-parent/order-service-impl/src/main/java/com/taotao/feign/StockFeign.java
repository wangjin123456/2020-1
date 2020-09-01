package com.taotao.feign;

import com.taotao.stock.StockService;
import org.springframework.cloud.openfeign.FeignClient;

/**
 *@author tom
 *Date  2020/5/4 0004 22:19
 *
 */
@FeignClient("antmeite-stock")
public interface StockFeign extends StockService {
}
