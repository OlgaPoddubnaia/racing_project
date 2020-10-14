package com.olga.racing;

import com.olga.racing.entity.Horses;
import com.olga.racing.entity.TypesOfBets;
import com.olga.racing.service.HorsesService;
import com.olga.racing.service.TypesOfBetsService;

import java.sql.SQLException;
import java.util.List;

public class Main {


    public static void main(String[] args) throws SQLException {
        TypesOfBetsService typesOfBetsService = new TypesOfBetsService();
        List<TypesOfBets> types = typesOfBetsService.getAll();
        for (TypesOfBets t : types) {
            System.out.println(t);
        }


        HorsesService horsesService = new HorsesService();
        List<Horses> horses = horsesService.getAll();
        for (Horses h : horses
        ) {
            System.out.println(h);
        }


        HorsesService horsesService2 = new HorsesService();
        Horses horses1 = horsesService2.getByID(4);
        System.out.println(horses1);


    }
}
