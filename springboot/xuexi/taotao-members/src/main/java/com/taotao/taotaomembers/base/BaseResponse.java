package com.taotao.taotaomembers.base;

import lombok.Data;

/**
 * @author tom
 * Date  2020/4/15 0015 11:16
 */
@Data
public class BaseResponse <T>{

/**
 * 返回码
 */
private  Integer code;
/**
 * 消息
 */
private  String msg;
/**
 * 返回
 */
private  T data;

public  BaseResponse(){

}

    public BaseResponse(Integer code, String msg, T data) {
       super();
       this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
