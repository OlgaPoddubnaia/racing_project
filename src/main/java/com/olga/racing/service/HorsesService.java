package com.olga.racing.service;

import com.olga.racing.DBConnect;
import com.olga.racing.dao.HorsesDAO;
import com.olga.racing.entity.Horses;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HorsesService extends DBConnect implements HorsesDAO {

    Connection connection;

    public HorsesService() {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            System.out.println(e.toString());
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
    public void add(Horses horses) {
        PreparedStatement preparedStatement = null;

        String sql = "INSERT INTO racing_db.horses" + " (id, horse_name, rating, age, weight, coefficient)" + "VALUES(?,?,?,?,?,?)";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, horses.getId());
            preparedStatement.setString(2, horses.getHorseName());
            preparedStatement.setFloat(3, horses.getRating());
            preparedStatement.setInt(4, horses.getAge());
            preparedStatement.setString(5, horses.getWeight());
            preparedStatement.setFloat(6, horses.getCoefficient());

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
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void removeById(int id) {
        PreparedStatement preparedStatement = null;

        String sql = "DELETE FROM racing_db.horses WHERE id=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
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
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }
}
