package com.olga.racing.dao;

import com.olga.racing.entity.Result;

import java.util.List;

public interface ResultDAO {
    //read
    List<Result> getAll();

    //update
    void update(Result result);

    //delete
    void remove(Result result);


}
