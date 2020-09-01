package com.taotao.rmi;

import com.taotao.rmi.service.UserService;
import com.taotao.rmi.service.impl.UserServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * 3,将本地接口暴露出去
 */
@SpringBootApplication
public class RmiApplication {

    public static void main(String[] args) throws RemoteException, AlreadyBoundException, MalformedURLException {

        SpringApplication.run(RmiApplication.class, args);
    }

}
