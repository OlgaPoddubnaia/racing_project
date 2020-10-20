package com.olga.racing.dao;

import com.olga.racing.entity.Result;
import com.olga.racing.entity.TypesOfBets;

import java.sql.SQLException;
import java.util.List;

public interface TypesOfBetsDAO {
    //read
    List<TypesOfBets> getAll();

}
