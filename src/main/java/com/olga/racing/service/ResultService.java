package com.olga.racing.service;

import com.olga.racing.DBConnect;
import com.olga.racing.dao.ResultDAO;
import com.olga.racing.entity.Result;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ResultService extends DBConnect implements ResultDAO {

    Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

    public ResultService() throws SQLException {
        System.out.println("Ошибка подключения к БД");
    }

    @Override
    public List<Result> getAll() {
        List<Result> resultList = new ArrayList<>();

        String sql = "SELECT * FROM racing_db.result";

        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Result result = new Result();
                result.setId(resultSet.getInt("id"));
                result.setHorseId(resultSet.getInt("horseId"));
                result.setTypeOfBet(resultSet.getString("typeOfBet"));
                result.setMoney(resultSet.getFloat("money"));
                resultList.add(result);
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

        return resultList;
    }

    @Override
    public void add(Result result) {
        PreparedStatement preparedStatement = null;

        String sql = "INSERT INTO racing_db.result" + " (id, horseId, typeOfBet, money)" + "VALUES(?,?,?,?)";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, result.getId());
            preparedStatement.setInt(2, result.getHorseId());
            preparedStatement.setString(3, result.getTypeOfBet());
            preparedStatement.setFloat(4, result.getMoney());

            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("SQLException ");
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
    }


    @Override
    public void remove(Result result) {
        PreparedStatement preparedStatement = null;

        String sql = "DELETE FROM racing_db.result WHERE id=?";
        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, result.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("SQLException ");
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

    }


}
