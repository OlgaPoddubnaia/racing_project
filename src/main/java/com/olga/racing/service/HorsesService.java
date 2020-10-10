package com.olga.racing.service;

import com.olga.racing.DBConnect;
import com.olga.racing.dao.HorsesDAO;
import com.olga.racing.entity.Horses;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HorsesService extends DBConnect implements HorsesDAO {

    Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

    public HorsesService() throws SQLException {
        System.out.println("Ошибка подключения к БД");
    }

    @Override
    public List<Horses> getAll() {
        List<Horses> horsesList = new ArrayList<>();

        String horseSQL = "SELECT id, horseName, rating, age, weight, coefficient";

        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(horseSQL);

            while (resultSet.next()) {
                Horses horses = new Horses();
                horses.setId(resultSet.getInt("id"));
                horses.setHorseName(resultSet.getString("horseName"));
                horses.setRating(resultSet.getFloat("rating"));
                horses.setAge(resultSet.getInt("age"));
                horses.setWeight(resultSet.getString("weight"));
                horses.setCoefficient(resultSet.getFloat("coefficient"));

                horsesList.add(horses);
            }

        } catch (SQLException ex) {
            System.out.println("SQLException ");
        } finally {
            try {
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

        String horseSQL = "SELECT horseName, rating, age, weight, coefficient FROM horses WHERE id=?";

        Horses horses = new Horses();
        try {
            preparedStatement = connection.prepareStatement(horseSQL);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery(horseSQL);

            horses.setId(resultSet.getInt("id"));
            horses.setHorseName(resultSet.getString("horseName"));
            horses.setRating(resultSet.getFloat("rating"));
            horses.setAge(resultSet.getInt("age"));
            horses.setWeight(resultSet.getString("weight"));
            horses.setCoefficient(resultSet.getFloat("coefficient"));

            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("SQLException ");
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return horses;
    }
}
