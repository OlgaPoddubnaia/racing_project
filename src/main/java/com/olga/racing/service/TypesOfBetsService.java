package com.olga.racing.service;

import com.olga.racing.DBConnect;
import com.olga.racing.dao.TypesOfBetsDAO;
import com.olga.racing.entity.Result;
import com.olga.racing.entity.TypesOfBets;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TypesOfBetsService extends DBConnect implements TypesOfBetsDAO {
    Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

    public TypesOfBetsService() throws SQLException {
        System.out.println("Ошибка подключения к БД");
    }

    @Override
    public List<TypesOfBets> getAll() {
        List<TypesOfBets> betsList = new ArrayList<>();

        String sql = "SELECT type, description";

        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
             TypesOfBets typesOfBets= new TypesOfBets();
                typesOfBets.setType(resultSet.getString("type"));
                typesOfBets.setDescription(resultSet.getString("description"));
                betsList.add(typesOfBets);
            }

        } catch (SQLException ex) {
            System.out.println("SQLException");
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
        return betsList;
    }
}