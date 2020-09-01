package com.taotao.jvm03;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @ClassName Test003
 * @Author 蚂蚁课堂余胜军 QQ644064779 www.mayikt.com
 * @Version V1.0
 **/
public class Test003 {
    public static void main(String[] args) throws SQLException {
//        Thread.currentThread().setContextClassLoader(Test003.class.getClassLoader().getParent());
        Connection root =
                DriverManager
                        .getConnection
                                (
                                        "jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC&useSSL=true",
                                        "root", "root");
        ServiceLoader<Driver> loadedDrivers = ServiceLoader.load(Driver.class);
        loadedDrivers.forEach(t -> {
            System.out.println(t);
        });



    }
}
