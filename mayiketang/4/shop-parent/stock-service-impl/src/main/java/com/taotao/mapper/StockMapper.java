package com.taotao.mapper;

import com.taotao.entity.StockEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


/**
 *@author tom
 *Date  2020/5/4 0004 22:37
 *
 */
@Mapper
public interface StockMapper {

    @Select("SELECT id as id ,commodity_id as  commodityId, stock as stock from stock where commodity_id=#{commodityId}")
    public StockEntity selectStock(@Param("commodityId") Long commodityId);

    @Update("update stock set stock=stock-1 where commodity_id=#{commodityId}")
    public int updateStock(@Param("commodityId") Long commodityId);

}

