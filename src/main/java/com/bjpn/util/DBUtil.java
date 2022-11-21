package com.bjpn.util;

import java.sql.*;

public class DBUtil {
    static{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    //提供连接的方法
    public static Connection getConn(){
        Connection conn =null;
        try {
            String url="jdbc:mysql://localhost:3306/oa?serverTimezone=UTC&useSSL=false";
            conn = DriverManager.getConnection(url,"root","root");
            return conn;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    //关闭的方式
    public static void closeConn(Connection conn){
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void closePsta(PreparedStatement psta){
        if(psta!=null){
            try {
                psta.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void closeResultSet(ResultSet resultSet){
        if(resultSet!=null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
