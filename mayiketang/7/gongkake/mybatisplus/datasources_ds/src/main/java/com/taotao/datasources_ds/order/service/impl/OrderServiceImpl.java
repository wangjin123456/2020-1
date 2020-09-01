package com.taotao.datasources_ds.order.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.taotao.datasources_ds.order.entity.Order;
import com.taotao.datasources_ds.order.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2020-06-17
 */
@RestController
@DS("itmayidu-order")
public class OrderServiceImpl {

    @Autowired
    private  OrderMapper orderMapper;

    @GetMapping("/findByorderId")
    public  Order findByorderId(Long id){
      Order order=  orderMapper.selectById(id);
        return  order;
    }
}
