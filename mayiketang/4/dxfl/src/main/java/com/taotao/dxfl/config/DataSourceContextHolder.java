package com.taotao.dxfl.config;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 *@author tom
 *Date  2020/8/22 0022 10:09
 *
 */
@Component
@Lazy(false)
public class DataSourceContextHolder {
    // 采用ThreadLocal 保存本地多数据源
    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();

    // 设置数据源类型
    public static void setDbType(String dbType) {
        contextHolder.set(dbType);
    }

    public static String getDbType() {
        return contextHolder.get();
    }

    public static void clearDbType() {
        contextHolder.remove();
    }

}