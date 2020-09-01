package com.itmayidu.service.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 *@author tom
 *Date  2020/4/28 0028 12:01
 *
 */
//@Component
public class TokenFilter  extends ZuulFilter {
    @Value("${server.port}")
    private  String serverport;

    /**
     * 过滤类型 pre 表示在请求之前进行执行
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 过滤器执行顺序 ，当一个请求在同一阶段的时候存在多个过滤器的时候，多个过滤器执行顺序
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

     //编写业务逻辑代码
    @Override
    public Object run() throws ZuulException {
        //获取所有的服务接口，判断服务是否有传递token
        //1获取上下文
        RequestContext currentcontext= RequestContext.getCurrentContext();
        //获取request
        HttpServletRequest request=currentcontext.getRequest();
        String token=request.getParameter("userToken");
        if(Strings.isBlank(token)){
            currentcontext.setSendZuulResponse(false);
            currentcontext.setResponseBody("token is null");
            currentcontext.setResponseStatusCode(401);
        }
        System.out.println("服务端口号：serverport="+serverport);
        return null;
    }
}
