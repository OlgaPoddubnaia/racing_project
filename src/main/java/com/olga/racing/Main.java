package com.olga.racing;

import com.olga.racing.service.HorsesService;
import com.olga.racing.service.TypesOfBetsService;

import java.sql.SQLException;

public class Main {


    public static void main(String[] args) throws SQLException {
       TypesOfBetsService typesOfBetsService = new TypesOfBetsService();
        System.out.println(typesOfBetsService.getAll().toArray());

      /* HorsesService horsesService = new HorsesService();
        System.out.println(horsesService.getByID(2));*/


    }
}
