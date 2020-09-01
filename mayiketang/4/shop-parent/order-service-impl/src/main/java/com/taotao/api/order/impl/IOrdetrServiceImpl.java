package com.taotao.api.order.impl;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.taotao.base.BaseApiService;
import com.taotao.base.ResponseBase;
import com.taotao.entity.OrderEntity;
import com.taotao.feign.StockFeign;
import com.taotao.mapper.OrderMapper;
import com.taotao.order.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 *@author tom
 *Date  2020/5/4 0004 22:09
 *
 */
@RestController
public class IOrdetrServiceImpl  extends BaseApiService implements IOrderService {
   @Autowired
   private OrderMapper orderMapper;
   @Autowired
   private StockFeign stockFeign;

    @LcnTransaction //分布式事务注解
    @Transactional
    @Override
   @RequestMapping(value = "/addOrderAndStock")
    public ResponseBase addOrderAndStock(int i) throws Exception {
       OrderEntity orderEntity=new OrderEntity();
       orderEntity.setName("充值");
       orderEntity.setOrderCreatetime(new Date());
       //价格 30元
       orderEntity.setOrderMoney(300d);
       //状态为未支付
       orderEntity.setOrderState(0);
       Long comodityId=30L;
       //商品id
       orderEntity.setCommodityId(comodityId);
       //////////////////////
       //1,先下单，在创建订单（订单数据库中插入一条数据）
       int orderResult=orderMapper.addOrder(orderEntity);
       System.out.println("orderResult:"+orderEntity);
       if(orderResult<=0){
           return  setResultError("下单失败");
       }
       //2 下单成功后调用库存服务（对该商品数量减1，）采用feign 客户端进行调用服务接口
       ResponseBase inventoryReduction =stockFeign.inventoryReduction(comodityId);
       if(inventoryReduction.getRtnCode() !=200){
           //1,使用手动事务
           // TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
           // 2.获取将异常抛出给上一层，外面回滚。
           throw  new Exception("调用库存接口失败，开启回退订单服务代码");

       }
       int result =1/i;
       System.out.println("result:"+ result);
        return setResultSuccess("下单成功");
    }
}
