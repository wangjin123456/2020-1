package com.taotao.springbootword.service;

/**
 *@author tom
 *Date  2020/4/18 0018 10:04
 *
 */

import java.util.List;
import java.util.Map;

public interface DataSourceDetailService {
    /**
     * 描述 根据表名称获取表的详细信息
     * @param tableName
     * @return
     */
    List<Map<String,Object>> getDataSourceDetail(String tableName);

    /**
     * 根据数据库名称获取表的详细信息
     * @param dbName
     * @return
     */
    List<Map<String,Object>> getAllDataSourceName(String dbName);

    /**
     * 讲数据写出到指定的world文档
     * @param list
     */
    void toWord(List<Map<String, Object>> list);
}

