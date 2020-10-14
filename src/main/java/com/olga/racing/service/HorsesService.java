package com.olga.racing.service;

import com.olga.racing.DBConnect;
import com.olga.racing.dao.HorsesDAO;
import com.olga.racing.entity.Horses;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HorsesService extends DBConnect implements HorsesDAO {

    Connection connection;

    {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            System.out.println( "ошибка");
        }
    }



    @Override
    public List<Horses> getAll() {
        List<Horses> horsesList = new ArrayList<>();

        String sql = "SELECT * FROM racing_db.horses";


        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Horses horses = new Horses();
                horses.setId(resultSet.getInt("id"));
                horses.setHorseName(resultSet.getString("horse_name"));
                horses.setRating(resultSet.getFloat("rating"));
                horses.setAge(resultSet.getInt("age"));
                horses.setWeight(resultSet.getString("weight"));
                horses.setCoefficient(resultSet.getFloat("coefficient"));

                horsesList.add(horses);
            }


        } catch (SQLException ex) {
            System.out.println(ex.toString());
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return horsesList;
    }

    @Override
    public Horses getByID(int id) {
        PreparedStatement preparedStatement = null;

        String sql = "SELECT id, horse_name, rating, age, weight, coefficient FROM racing_db.horses WHERE id=?";

        Horses horses = new Horses();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery(sql);

            horses.setId(resultSet.getInt("id"));
            horses.setHorseName(resultSet.getString("horse_name"));
            horses.setRating(resultSet.getFloat("rating"));
            horses.setAge(resultSet.getInt("age"));
            horses.setWeight(resultSet.getString("weight"));
            horses.setCoefficient(resultSet.getFloat("coefficient"));

            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return horses;
    }
}
