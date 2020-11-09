package com.taotao.webservice_member.service;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

/**
 *@author tom
 *Date  2020/11/9 0009 8:09
 *
 */
@WebService
public class UserService {

    @WebMethod
public  String getUser(long UserId){
    return  "2222+"+UserId;
}

    public static void main(String[] args) {
        Endpoint.publish("http://127.0.0.1:8089/service/UserService",new UserService());
        System.out.println("服务发布成功 ");
    }
}
