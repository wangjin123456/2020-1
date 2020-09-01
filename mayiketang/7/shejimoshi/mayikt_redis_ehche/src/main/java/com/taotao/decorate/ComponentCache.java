package com.taotao.decorate;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 *@author tom
 *Date  2020/5/26 0026 9:09
 *
 */
public interface ComponentCache {

    /**
     * 根据key 查询缓存数据
     * @param key
     * @param <T>
     * @return
     */
    <T> T getCacheEntity(String key, Class<T> t,ProceedingJoinPoint proceedingJoinPoint);
}
