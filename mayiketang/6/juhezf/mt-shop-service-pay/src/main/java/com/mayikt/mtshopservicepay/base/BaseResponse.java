package com.mayikt.mtshopservicepay.base;

import lombok.Data;

/**
 *@author tom
 *Date  2020/4/21 0021 9:24
 *
 */
@Data
public class BaseResponse<T> {
    /**
     * 返回码
     */
    private Integer code;
    /**
     * 消息
     */
    private String msg;
    /**
     * 返回
     */
    private T data;
    // 分页

    public BaseResponse() {

    }

    public BaseResponse(Integer code, String msg, T data) {
        super();
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
