package com.taotao.mayikt_transcational.aop;

import java.lang.annotation.*;

/**
 *@author tom
 *Date  2020/5/28 0028 9:26
 *
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface MeiteTransaction {
}
