package com.taotao.order;

import com.taotao.base.ResponseBase;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *@author tom
 *Date  2020/5/4 0004 21:58
 *
 */
public interface IOrderService {

    /**
     * 用户下单后调用库存服务进行扣库存
     *
     * @return
     */
    @GetMapping(value = "/addOrderAndStock")
    public ResponseBase addOrderAndStock(int i) throws Exception;

}
