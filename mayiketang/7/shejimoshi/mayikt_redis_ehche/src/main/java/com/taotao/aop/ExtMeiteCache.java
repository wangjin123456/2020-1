package com.taotao.aop;

import java.lang.annotation.*;

/**
 *@author tom
 *Date  2020/5/26 0026 9:50
 *自定义注解
 */
@Target({ElementType.METHOD})//作用于方法上
@Retention(RetentionPolicy.RUNTIME)//可以通过java反射获取该注解
@Documented
public @interface ExtMeiteCache {
}
