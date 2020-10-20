package com.olga.racing;

import java.sql.*;

public class DBConnect {
    public static final String URL = "jdbc:mysql://localhost:3306/racing_db?useSSL=false&serverTimezone=UTC";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "root";

    public static void main(String[] args) {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Соединение с БД установлено");
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.toString());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                System.out.println(throwables.toString());
            }
        }
    }
}