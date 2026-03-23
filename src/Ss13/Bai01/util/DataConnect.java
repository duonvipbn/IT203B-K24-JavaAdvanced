package Ss13.Bai01.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataConnect {
    private final static String DRIVER = "com.mysql.cj.jdbc.Driver";
    private final static String URL = "jdbc:mysql://localhost:3306/my_hospital";
    private final static String USER = "root";
    private final static String PASSWORD = "@Duong19112006";

    public static Connection getConnection(){
        Connection conn;
        try{
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        }catch (ClassNotFoundException | SQLException e){
            throw new RuntimeException(e);
        }
        return conn;
    }
}