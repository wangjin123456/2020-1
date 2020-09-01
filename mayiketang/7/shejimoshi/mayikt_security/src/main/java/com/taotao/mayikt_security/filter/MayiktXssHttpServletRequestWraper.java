package com.taotao.mayikt_security.filter;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.logging.log4j.util.Strings;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 *@author tom
 *Date  2020/6/8 0008 0:06
 *
 */
public class MayiktXssHttpServletRequestWraper extends HttpServletRequestWrapper {


    public MayiktXssHttpServletRequestWraper(HttpServletRequest request) {
        super(request);
    }

    /**
     * 过滤参数
     * @param name
     * @return
     */
    @Override
    public String getParameter(String name) {
        String oldvalue=super.getParameter(name);
        if(Strings.isEmpty(oldvalue)){
            return  oldvalue;
        }
        //对html特殊字符实现转移
       // oldvalue.replace("<","&lt;");
       // oldvalue.replace(">","&gt;");
       String newValue= StringEscapeUtils.escapeHtml4(oldvalue);

        return newValue;
    }
}
