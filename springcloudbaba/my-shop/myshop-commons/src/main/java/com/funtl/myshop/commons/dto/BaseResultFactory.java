package com.funtl.myshop.commons.dto;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 通用响应解构工厂
 * @author tom
 * @date 2020/3/27 0027 9:16
 */
public class BaseResultFactory<T extends  AbstractBaseDomain> {
    private  static  final String LOGGER_LEVEL_DEBUG="DEBUG";
    private  static  BaseResultFactory baseResultFactory;
     //设置通用的响应
    private   static  HttpServletResponse response;
    public BaseResultFactory() {
    }

    public  static  BaseResultFactory getInstance(HttpServletResponse response){
        if(baseResultFactory ==null){
            synchronized (BaseResultFactory.class){
                if(baseResultFactory ==null){
                    baseResultFactory=new BaseResultFactory();
                }
            }
        }
        BaseResultFactory.response=response;
        return  baseResultFactory;
    }


    /**
     * 构建单笔数据结果集
     *
     * @param self
     * @param attribute
     * @return
     */
    public AbstractBaseResult build(String self,T attribute) {

        return new SuccessResult(self, attribute);
    }

    /**
     * 构建多笔数据结果集
     *
     * @param self
     * @param next
     * @param last
     * @return
     */
    public AbstractBaseResult build(String self, int next, int last, List<T> attributes) {
        return new SuccessResult(self, next, last, attributes);
    }

    /**
     * 构建请求错误的响应解构
     * @param code
     * @param title
     * @param detail
     * @param level  日志级别，只有 DEBUG 时 才显示详情
     * @return
     */
    public  AbstractBaseResult build(int code,String title,String detail,String level){
        // 设置请求失败的响应码
        response.setStatus(code);
        if(LOGGER_LEVEL_DEBUG.equals(level)){
            return  new ErrorResult(code,title,detail);
        }else {
            return  new ErrorResult(code,title,null);
        }

    }

    /**
     * 初始化 HttpServletResponse
     */
    private  void initResponse(){
        //需要符合JSOn API 规范
        response.setHeader("Content-Type","application/vnd.api+json");
    }
}
