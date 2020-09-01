package com.taotao.mybatis.service;

import java.lang.annotation.*;

/**
 *
 * 自定义注解，用于标识方法是否需要缓存
 * @author tom
 * @date 2020/4/6 0006 9:47
 */
@Target(value = {ElementType.PARAMETER, ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface NeedCacheAop {
    //代表缓存策略，nx: 代表key 不存在再进行缓存kv, xx： 代表key存在，在进行缓存kv，默认为不存在key缓存
    String nxxx() default  "nx";
    //代表过期时间单位， ex:秒 px: 毫秒  默认秒
    String expx() default "ex";
    //过期时间
    long time() default  30*60;


}
