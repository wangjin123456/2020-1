package com.funtl.myshop.commons.utils;

/**
 * 工具类
 * @author tom
 * @date 2020/3/27 0027 18:08
 */
public class RegexpUtils {
    /**
     * 验证手机号
     */
    public  static  final String PHONE="^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";
/**
 * 验证邮箱的地址
 */
public static final String EMAIL = "\\w+(\\.\\w)*@\\w+(\\.\\w{2,3}){1,3}";


    public static  boolean checkPhone(String phone){
        return  phone.matches(PHONE);
    }

    public  static  boolean checkEmail(String email){
        return  email.matches(EMAIL);
    }
}
