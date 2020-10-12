package com.olga.racing.dao;

import com.olga.racing.entity.Result;

import java.sql.SQLException;
import java.util.List;

public interface ResultDAO {
    //read
    List<Result> getAll();

    //add
    void add(Result result) throws SQLException;



    //delete
    void remove(Result result);
}
