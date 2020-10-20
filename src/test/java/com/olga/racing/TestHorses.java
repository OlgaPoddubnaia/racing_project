package com.olga.racing;

import com.olga.racing.entity.Horses;
import com.olga.racing.service.HorsesService;
import org.testng.Assert;
import org.testng.annotations.Test;



public class TestHorses {

    @Test
    public void testGetAll() {
        Horses horses = new Horses();
        horses.setId(10);
        horses.setHorseName("Leila");
        horses.setRating(5);
        horses.setAge(8);
        horses.setWeight("11-2");
        horses.setCoefficient(8);


        HorsesService horsesService = new HorsesService();
        System.out.println("Проверка о добавления horsesService.getAll().isEmpty() = "+horsesService.getAll().isEmpty());

        HorsesService horsesService1 = new HorsesService();
        horsesService1.add(horses);

        HorsesService horsesService2 = new HorsesService();
        Assert.assertTrue(horsesService2.getAll().contains(horses));
    }

}

