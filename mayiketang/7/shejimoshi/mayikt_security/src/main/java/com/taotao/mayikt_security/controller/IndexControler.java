package com.taotao.mayikt_security.controller;

import com.taotao.mayikt_security.utils.SignUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.Objects;

/**
 *@author tom
 *Date  2020/6/7 0007 22:12
 *
 */
@Controller

public class IndexControler {

    @RequestMapping("/getUserInfo")
    public  String getUserInfo(HttpServletRequest request){
        request.setAttribute("userName",request.getParameter("userName"));
        return  "userinfo";
    }

    @ResponseBody
    @RequestMapping("/toPay")
    public  String getMeiteUser(Long amount){
    HttpServletRequest request= ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
        Map<String,String[]> parameterMap=request.getParameterMap();
         if(!SignUtil.verifyMap(parameterMap)){
             return  "请求参数可能发生篡改，验证签名失败";
         }

       return "用户支付金额："+amount;
    }
}
