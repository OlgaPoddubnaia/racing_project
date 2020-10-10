package com.olga.racing;

import java.sql.*;


public class Main {
    private static final String URL = "jdbc:mysql://localhost:3306/racing_db?useSSL=false&serverTimezone=UTC";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();


            String SQL = "SELECT * FROM todays_racing";
            ResultSet resultSet = statement.executeQuery(SQL);
           //statement.executeUpdate("INSERT INTO todays_racing( horse_name, rating, age, weight) VALUES ( 'check', 9.4, 8, '11-0');");
            //statement.executeUpdate("delete from todays_racing where id = 11");

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                System.out.println("id: " + id);
                System.out.println("Name: " + name);
                System.out.println("===================\n");
            }




            System.out.println("Соединение с БД установлено");

        } catch (SQLException ex) {

            System.out.println("SQLException ");
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException");
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}