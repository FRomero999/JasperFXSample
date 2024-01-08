package com.example.jasperfxsample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {

    static private Connection con;

    static{
        try {
            con =  DriverManager.getConnection("jdbc:mysql://localhost/ad","root","");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection(){
        return con;
    }
}
