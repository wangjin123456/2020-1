package com.taotao.springbootword.mapper;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.*;
/**
 * @author Administrator
 */
@Mapper
public interface DataSourceMapper {
    /**
     * 根据表名获取详细信息
     * @param tableName
     * @return
     */
    @Select("SHOW FULL FIELDS FROM ${tableName}")
    List<Map<String, Object>> getDataDetail(@Param("tableName") String tableName);
    /**
     * 根据数据库名称获取数据库中表的名称和注释
     * @param dbName
     * @return
     */

    @Select("select table_name as name,table_comment as comment from information_schema.tables where table_schema =#{dbName} order by table_name")
    List<Map<String,Object>> getAllDataSourceName(@Param("dbName")String dbName);
}
