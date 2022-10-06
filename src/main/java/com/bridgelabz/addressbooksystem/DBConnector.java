package com.bridgelabz.addressbooksystem;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnector {
    String URL = "jdbc:mysql://localhost:3306/addressbook_service";
    String USER = "root";
    String PASS = "Yasin@786";

    Connection connection;

    public DBConnector() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public Connection getConnection(){
        try{
            connection = DriverManager.getConnection(URL, USER, PASS);
            return connection;
        }
        catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
