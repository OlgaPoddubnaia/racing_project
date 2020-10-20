package com.olga.racing.dao;

import com.olga.racing.entity.Horses;
import com.olga.racing.entity.Result;

import java.sql.SQLException;
import java.util.List;

public interface HorsesDAO {
    //read
    List<Horses> getAll() throws SQLException;

}
