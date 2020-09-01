package com.taotao.taotaomembers.base;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * 微服务接口实现该接口可以使用传递参数可以直接封装统一返回结果集
 *
 * @author tom
 * Date  2020/4/15 0015 10:43
 */
@Data
@Component
public class BaseApiService<T> {
    public BaseResponse<T> setResultError(Integer code, String msg) {
        return setResult(code, msg, null);
    }

    /**
     * 返回错误，可以传msg
     * @param msg
     * @return
     */
    public  BaseResponse<T> setResultError(String msg){
        return  setResult(Contains.HTTP_RES_CODE_500,msg,null);
    }

    /**
     * 返回成功，可以传回data值
     * @param data
     * @return
     */
    public  BaseResponse<T> setResultSuccess(T data){
        return  setResult(Contains.HTTP_RES_CODE_200,Contains.HTTP_RES_CODE_200_VALUE,data);
    }

    /**
     * 返回成功，不传data 值
     * @return
     */
    public  BaseResponse<T> setResultSuccess(){
        return  setResult(Contains.HTTP_RES_CODE_200,Contains.HTTP_RES_CODE_200_VALUE,null);
    }
    public  BaseResponse<T> setResultSuccess(String msg){
        return  setResult(Contains.HTTP_RES_CODE_200,msg,null);
    }

    //通用封装
    public BaseResponse<T> setResult(Integer code, String msg, T data) {
        return new BaseResponse<T>(code, msg, data);
    }


}
