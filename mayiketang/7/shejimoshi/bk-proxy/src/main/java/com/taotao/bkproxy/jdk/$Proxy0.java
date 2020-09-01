package com.taotao.bkproxy.jdk;

import com.taotao.bkproxy.service.OrderService;

import java.lang.reflect.Method;

/**
 *@author tom
 *Date  2020/5/18 0018 7:30
 *
 */
public class $Proxy0  implements OrderService {
    private  ExtMyInvocationHandler h;

    public $Proxy0(ExtMyInvocationHandler h) {
        this.h = h;
    }

    @Override
    public String addOrder(String orderId, String orderName) {
       try {
           Method m3=Class.forName("com.taotao.bkproxy.service.OrderService").getMethod("addOrder", Class.forName("java.lang.String"), Class.forName("java.lang.String"));
           this.h.invoke(this,m3,new Object[]{orderId,orderName});
       }catch (Exception e){
           e.getCause();
       } catch (Throwable throwable) {
           throwable.printStackTrace();
       }

        return null;
    }
}
