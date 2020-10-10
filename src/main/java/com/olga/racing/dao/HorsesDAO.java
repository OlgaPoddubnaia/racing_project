package com.olga.racing.dao;

import com.olga.racing.entity.Horses;

import java.sql.SQLException;
import java.util.List;

public interface HorsesDAO {
    //read
    List<Horses> getAll() throws SQLException;

    //readByID
    Horses getByID(int id);

}
