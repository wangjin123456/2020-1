package com.taoto.jdbcs;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.*;
import java.util.LinkedList;
import java.util.logging.Logger;

/**
 *@author tom
 *Date  2020/10/13 0013 9:14
 *
 */
public class MKDataSource implements DataSource {
    private String driverClassName = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC&useSSL=true";
    private String username = "root";
    private String password = "root";
    private LinkedList<Connection> connections = new LinkedList<Connection>();


    public MKDataSource(int initialSize) throws ClassNotFoundException, SQLException {
        Class.forName(driverClassName);//执行驱动
        for (int i = 0; i < initialSize; i++) {
            Connection connection = DriverManager.getConnection(url, username, password);
            connections.add(connection);

        }
    }
//获取连接
    @Override
    public Connection getConnection() throws SQLException {
         /* Connection first=connections.getFirst();
          connections.remove(first);*/
        Connection first=connections.removeFirst();
        return first;
    }

    //关闭连接
    public  void closeConnection(Connection connection){
              connections.add(connection);
    }
    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return null;
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {

    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {

    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        MKDataSource mkDataSource=new MKDataSource(2);

        for (int i = 0; i <10 ; i++) {

            Connection connection= mkDataSource.getConnection();
            PreparedStatement pstmt=connection.prepareStatement("SELECT * from  order_info WHERE 1=1");
            ResultSet resultSet=pstmt.executeQuery();
            System.out.println("发送结果"+connection);
            if(resultSet==null){
                return;
            }
            if(resultSet.next()){
                String name=resultSet.getNString("name");
                System.out.println("查询结果："+name);
            }
        if(resultSet !=null)
            resultSet.close();
        if(pstmt!=null){
            pstmt.close();
        }
        mkDataSource.closeConnection(connection);

        }


    }
}
