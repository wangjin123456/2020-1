package com.taotao.rmi.service.impl;

import com.taotao.rmi.service.UserService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 *2， 实现接口 ，并继承： UnicastRemoteObject
 * @autor tom
 * @date 2020/3/20 0020 11:10
 */
public class UserServiceImpl extends UnicastRemoteObject implements UserService  {
    public UserServiceImpl() throws RemoteException {
    }

    @Override
    public String sayHello(String name) throws RemoteException {
        return name+" 成功的调用了服务端的服务";
    }

}
