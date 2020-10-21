package com.olga.racing.dao;

import com.olga.racing.entity.Horses;

import java.sql.SQLException;
import java.util.List;

public interface HorsesDAO {
    //read
    List<Horses> getAll() throws SQLException;

    //add
    void add(Horses horses);

    //delete by Id
    void removeById(int id);

}
