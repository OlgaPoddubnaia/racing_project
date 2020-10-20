package com.olga.racing.service;

import com.olga.racing.DBConnect;
import com.olga.racing.dao.ResultDAO;
import com.olga.racing.entity.Result;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ResultService extends DBConnect implements ResultDAO {

    Connection connection;

    public ResultService() {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
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
                result.setHorseId(resultSet.getInt("horse_id"));
                result.setTypeOfBet(resultSet.getString("type_of_bet"));
                result.setMoney(resultSet.getFloat("money"));
                resultList.add(result);
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
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return resultList;
    }

    @Override
    public void add(Result result) {
        PreparedStatement preparedStatement = null;

        String sql = "INSERT INTO racing_db.result" + " (id, horse_id, type_of_bet, money)" + "VALUES(?,?,?,?)";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, result.getId());
            preparedStatement.setInt(2, result.getHorseId());
            preparedStatement.setString(3, result.getTypeOfBet());
            preparedStatement.setFloat(4, result.getMoney());

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

        String sql = "DELETE FROM racing_db.result WHERE id=?";
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

    @Override
    public void deleteAll() {
        PreparedStatement preparedStatement = null;

        String sql = "TRUNCATE TABLE racing_db.result ";
        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.execute(sql);
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
}
