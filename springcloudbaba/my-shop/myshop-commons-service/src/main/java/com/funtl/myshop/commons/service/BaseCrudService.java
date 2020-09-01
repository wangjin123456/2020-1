package com.funtl.myshop.commons.service;

import com.funtl.myshop.commons.dto.AbstractBaseDomain;
import com.github.pagehelper.PageInfo;

/**
 * 通用业务逻辑
 *
 * @author tom
 * @date 2020/3/27 0027 18:14
 */
public interface BaseCrudService<T extends AbstractBaseDomain> {
    /**
     * 查询属性是否唯一
     *
     * @param property
     * @param value
     * @return true 唯一   ，false 不唯一
     */
    default boolean unique(String property, String value) {
        return false;
    }

    /**
     * 保存
     * @param domain
     * @return
     */
    default T save(T domain) {
        return null;
    }

    /**
     * 分页查询
     * @param domain
     * @param pageNum
     * @param pageSize
     * @return
     */
    default PageInfo<T> page(T domain,int pageNum,int pageSize){
        return null;
    }

}
