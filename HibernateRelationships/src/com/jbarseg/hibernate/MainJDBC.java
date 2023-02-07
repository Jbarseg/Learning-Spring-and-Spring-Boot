package com.jbarseg.hibernate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MainJDBC {
    public static void main(String[] args) {

        final String JDBC_URL = "jdbc:mysql://localhost:3306/hibernate?useSSL=false";
        final String JDBC_USER = "root";
        final String JDBC_PASSWORD = "admin";

        try {
            Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
            System.out.println("Succesful Connection");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }


    }
}
