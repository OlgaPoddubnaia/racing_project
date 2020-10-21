package com.olga.racing;

import com.olga.racing.entity.TypesOfBets;
import com.olga.racing.service.TypesOfBetsService;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestTypesOfBets {

    @Test(priority = 1)
    public void testAdd() {
        TypesOfBets typesOfBets = new TypesOfBets();
        typesOfBets.setType("TestAdd");
        typesOfBets.setDescription("Description for testAdd");

        TypesOfBetsService typesOfBetsService = new TypesOfBetsService();
        System.out.println("Проверяем есть ли такая ставка до добавления. Результат = " + typesOfBetsService.getAll().contains(typesOfBets));

        TypesOfBetsService typesOfBetsService1 = new TypesOfBetsService();
        typesOfBetsService1.add(typesOfBets);

        TypesOfBetsService typesOfBetsService2 = new TypesOfBetsService();
        Assert.assertTrue(typesOfBetsService2.getAll().contains(typesOfBets));
    }

    @Test(priority = 2)
    public void testGetAll() {
        TypesOfBets typesOfBets = new TypesOfBets();
        typesOfBets.setType("TestGetALL");
        typesOfBets.setDescription("Description for testGetAll");

        TypesOfBetsService typesOfBetsService = new TypesOfBetsService();
        System.out.println("Проверяем есть ли такая ставка до добавления. Результат = " + typesOfBetsService.getAll().contains(typesOfBets));

        TypesOfBetsService typesOfBetsService1 = new TypesOfBetsService();
        typesOfBetsService1.add(typesOfBets);

        TypesOfBetsService typesOfBetsService2 = new TypesOfBetsService();
        Assert.assertTrue(typesOfBetsService2.getAll().contains(typesOfBets));
    }

    @Test(priority = 3)
    public void testDeleteByType() {
        TypesOfBets typesOfBets = new TypesOfBets();
        typesOfBets.setType("TestDeleteBy");
        typesOfBets.setDescription("Description for testDeleteByType");

        TypesOfBetsService typesOfBetsService = new TypesOfBetsService();
        System.out.println("Проверяем есть ли такая ставка до добавления. Результат = " + typesOfBetsService.getAll().contains(typesOfBets));

        TypesOfBetsService typesOfBetsService1 = new TypesOfBetsService();
        typesOfBetsService1.add(typesOfBets);

        TypesOfBetsService typesOfBetsService2 = new TypesOfBetsService();
        System.out.println("Проверяем есть ли такая ставка после добавления. Результат = " + typesOfBetsService2.getAll().contains(typesOfBets));

        TypesOfBetsService typesOfBetsService3 = new TypesOfBetsService();
        typesOfBetsService3.removeByType("TestDeleteBy");

        //удаляем данные после методов add, getAll
        TypesOfBetsService typesOfBetsService4 = new TypesOfBetsService();
        typesOfBetsService4.removeByType("TestGetALL");
        TypesOfBetsService typesOfBetsService5 = new TypesOfBetsService();
        typesOfBetsService5.removeByType("TestAdd");

        TypesOfBetsService typesOfBetsService6 = new TypesOfBetsService();
        Assert.assertFalse(typesOfBetsService6.getAll().contains(typesOfBets));
    }

}

