package com.taotao.sigleton;

import java.io.*;

/**
 *@author tom
 *Date  2020/6/3 0003 23:12
 *
 */
public class Test02 {
    public static void main(String[] args) throws Exception {
        FileOutputStream fos=new FileOutputStream("D:/code/user.txt");
        ObjectOutputStream oos=new ObjectOutputStream(fos);
        Singleton01 singleton01=Singleton01.getInstance();
        oos.writeObject(singleton01);
             oos.close();
             fos.close();
         //2,从硬盘中反序列化对象到内存中
        ObjectInputStream ois=new ObjectInputStream(new FileInputStream("D:/code/user.txt"));
        Singleton01 singleton02= (Singleton01) ois.readObject();
        System.out.println(singleton01== singleton02);

    }
}
