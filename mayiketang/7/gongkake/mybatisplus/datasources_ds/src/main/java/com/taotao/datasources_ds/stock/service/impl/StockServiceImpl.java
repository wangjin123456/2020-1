package com.taotao.datasources_ds.stock.service.impl;


import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.taotao.datasources_ds.stock.entity.Stock;
import com.taotao.datasources_ds.stock.mapper.StockMapper;
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
@DS(value = "itmayidu-stock")
public class StockServiceImpl  {
 @Autowired
    private StockMapper stockMapper;

 @GetMapping("/findByuserId")
 public  Stock findByuserId(Long userid){
     return  stockMapper.selectById(userid);
 }

}
