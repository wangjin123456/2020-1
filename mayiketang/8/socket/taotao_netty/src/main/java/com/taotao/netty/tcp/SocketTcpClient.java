package com.taotao.netty.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;

/**
 *@author tom
 *Date  2020/11/6 0006 12:07
 *
 */
public class SocketTcpClient {
    public static void main(String[] args) throws IOException {
        //创建socket
        final Socket socket=new Socket();
        //创建socket地址
        SocketAddress address=new InetSocketAddress(InetAddress.getLocalHost(),8080);
    socket.connect(address);
   //创建PrintWriter
        PrintWriter socketout=new PrintWriter(socket.getOutputStream());
        BufferedReader socketIn=new BufferedReader(new InputStreamReader(socket.getInputStream()));
        //向服务发送的内容；
        String sendstr="1+1=?";
        socketout.write(sendstr);
            socketout.flush();
            String receiveStr=socketIn.readLine();
        System.out.println("服务器回复;"+receiveStr);
//关闭连接
        socketout.close();
        socketIn.close();
        socket.close();
    }


}
