package com.funtl.myshop.commons.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 请求失败
 * @author tom
 * @date 2020/3/27 0027 9:12
 */
@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
//@ JSON 不显示为 null 属性
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResult  extends  AbstractBaseResult{
    private  int code;
    private String title;
    private  String detail;
}
