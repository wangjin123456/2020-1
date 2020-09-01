package com.taotao.springbootword.controller;

/**
 *@author tom
 *Date  2020/4/18 0018 10:03
 *
 */

import com.taotao.springbootword.service.DataSourceDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;
import java.util.Map;

/**
 * 生成数据库表设计文档
 */
@RestController
@RequestMapping("/myTest")
public class DataSourceDetailController {
    @Autowired
    private DataSourceDetailService dataSourceDetailService;

    /**
     * 生成数据库表设计文档
     *
     * @param dbName
     * @return
     */
    @RequestMapping("/getDbDetail")
    public String getDbDetail(String dbName) {
        try {
            List<Map<String, Object>> list = this.dataSourceDetailService.getAllDataSourceName(dbName);
            this.dataSourceDetailService.toWord(list);
        }catch (Exception e){
            e.getCause();
            return  "生成数据库表设计文档失败";
        }
        return "生成数据库表设计文档成功";
    }

}


