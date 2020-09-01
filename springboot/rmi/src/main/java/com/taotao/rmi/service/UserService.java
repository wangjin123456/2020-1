package com.taotao.rmi.service;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * 第一步 创建远程接口，并且继承 java.rmi.Remote接口
 * @autor tom
 * @date 2020/3/20 0020 11:07
 */
public interface UserService  extends Remote {
    String sayHello(String name) throws RemoteException;
}
