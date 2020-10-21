package com.olga.racing.dao;

import com.olga.racing.entity.TypesOfBets;

import java.util.List;

public interface TypesOfBetsDAO {
    //read
    List<TypesOfBets> getAll();

    //add
    void add(TypesOfBets typesOfBets);

    //delete by Id
    void removeByType(String type);

}
