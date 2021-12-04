/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ADMIN
 */
public class DBConnect {
    public static Connection getConnection() throws ClassNotFoundException, SQLException{
        Connection con=null;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://localhost:1433;databaseName=PRJ301_SE1506_Assignment_Group6";
        con= DriverManager.getConnection(url, "sa", "123");
        return con;
    }
}
