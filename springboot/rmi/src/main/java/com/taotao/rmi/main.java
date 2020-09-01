package com.taotao.rmi;

import com.taotao.rmi.service.UserService;
import com.taotao.rmi.service.impl.UserServiceImpl;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * @autor tom
 * @date 2020/3/20 0020 12:21
 */
public class main {
    public static void main(String[] args) throws RemoteException, AlreadyBoundException, MalformedURLException {
        //1,启动rmi注册服务，指定一个端口号
     //   LocateRegistry.createRegistry(88888);
        //2,创建 要被访问的远程对象的实例
        UserService userService =new UserServiceImpl();
        //3,把远程对象实例注册到rmi注册服务器上
        Naming.bind("rmi://localhost:8888/UserService",userService);
        System.out.println("服务端启动中");
    }
}
