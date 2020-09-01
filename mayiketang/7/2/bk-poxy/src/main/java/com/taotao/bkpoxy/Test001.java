package com.taotao.bkpoxy;

import com.taotao.bkpoxy.service.impl.OrderServiceImpl;
import com.taotao.bkpoxy.service.proxy.OrserServiceProxy;

/**
 *@author tom
 *Date  2020/7/5 0005 20:32
 *
 */
public class Test001 {
    public static void main(String[] args) {

        OrserServiceProxy orserServiceProxy=new OrserServiceProxy();
        orserServiceProxy.addOrder("1","2");

    }
}
