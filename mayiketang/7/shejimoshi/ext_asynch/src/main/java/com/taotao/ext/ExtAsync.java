package com.taotao.ext;

import java.lang.annotation.*;

/**
 *@author tom
 *Date  2020/5/21 0021 18:21
 *
 */
@Target({ElementType.METHOD,ElementType.TYPE})//可以在类上使用注解也可以在方法上
@Retention(RetentionPolicy.RUNTIME)//反射注解
@Documented
public @interface ExtAsync {
}
