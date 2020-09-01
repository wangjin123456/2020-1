package com.taotao.datasources_ds.order.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.taotao.datasources_ds.order.entity.Order;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2020-06-17
 */
@Mapper
public interface OrderMapper extends BaseMapper<Order> {

}
