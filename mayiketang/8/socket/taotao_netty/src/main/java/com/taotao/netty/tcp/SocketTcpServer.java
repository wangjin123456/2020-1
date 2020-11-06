package com.taotao.netty.tcp;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.*;

/**
 *@author tom
 *Date  2020/11/6 0006 11:44
 *服务器端
 */
public class SocketTcpServer {
    public static void main(String[] args) throws IOException {
        //创建server
        ServerSocket serverSocket=new ServerSocket();
        //创建我们的socket 监听地址和端口号
        SocketAddress address=new InetSocketAddress(InetAddress.getLocalHost(),8080);
        //绑定我们的监听地址；
        serverSocket.bind(address);
     //等待接收请求；
        System.out.println("等待客户端发送消息..");
        Socket accept=serverSocket.accept();
        //获取OutPutStream流
        PrintWriter socketOut=new PrintWriter(accept.getOutputStream());
        byte buf[]=new byte[1024];
        if(accept.getInputStream().read(buf)>0){
            System.out.println("服务器端接收到客户端的消息："+new String(buf));

        }
        //服务器端响应消息
        String sendstr="1+1=2";
        socketOut.write(sendstr);
        socketOut.flush();
        //关闭所有的连接：
        socketOut.close();
        accept.close();
        serverSocket.close();
    }

}
