package com.olga.racing;

import com.olga.racing.entity.Result;
import com.olga.racing.service.HorsesService;
import com.olga.racing.service.ResultService;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TestResult {

    @Test(priority = 1)
    public void testGetAll() {
        Result result1 = new Result();
        result1.setId(1);
        result1.setHorseId(2);
        result1.setTypeOfBet("WIN");
        result1.setMoney(200);

        ResultService resultService = new ResultService();
        System.out.println("Проверка наличия result1 в resultService. Резульат = " + resultService.getAll().contains(result1));

        ResultService resultService1 = new ResultService();
        System.out.println("Проверка количества сущностей до добавления новой . Резульатат = " + resultService1.getAll().size());

        ResultService resultService2 = new ResultService();
        resultService2.add(result1);

        ResultService resultService3 = new ResultService();
        Assert.assertTrue(resultService3.getAll().contains(result1));
        ResultService resultService4 = new ResultService();
        Assert.assertEquals(resultService4.getAll().size(), 1);

    }

    @Test(priority = 2)
    public void testRemoveById() {
        Result result = new Result();
        result.setId(40);
        result.setHorseId(2);
        result.setTypeOfBet("SHOW");
        result.setMoney(2);

        ResultService resultService = new ResultService();
        resultService.add(result);

        ResultService resultService3 = new ResultService();
        System.out.println("Проверка есть ли result в resultService до удаления. Результат: " + resultService3.getAll().contains(result));

        int id = 40;

        ResultService resultService1 = new ResultService();
        resultService1.removeById(id);

        ResultService resultService2 = new ResultService();
        Assert.assertFalse(resultService2.getAll().contains(result));
    }


    @Test(priority = 3)
    public void testAdd() {
        Result result1 = new Result();
        result1.setId(30);
        result1.setHorseId(5);
        result1.setTypeOfBet("SHOW");
        result1.setMoney(400);

        ResultService resultService2 = new ResultService();
        System.out.println("Проверка, есть ли result1 до добавления в resultService = " + resultService2.getAll().contains(result1));

        ResultService resultService = new ResultService();
        resultService.add(result1);

        ResultService resultService1 = new ResultService();
        Assert.assertTrue(resultService1.getAll().contains(result1));
    }

    @Test(priority = 4)
    public void testDeleteAll() {
        Result result1 = new Result();
        result1.setId(20);
        result1.setHorseId(1);
        result1.setTypeOfBet("SHOW");
        result1.setMoney(140);

        Result result2 = new Result();
        result2.setId(21);
        result2.setHorseId(3);
        result2.setTypeOfBet("WIN");
        result2.setMoney(50);

        ResultService resultService = new ResultService();
        resultService.add(result1);

        ResultService resultService1 = new ResultService();
        resultService1.add(result2);

        ResultService resultService4 = new ResultService();
        System.out.println("Проверка, что до вызова метода удалния данных таблицы внесены данные в resultService есть = " + resultService4.getAll().isEmpty());

        ResultService resultService2 = new ResultService();
        resultService2.deleteAll();

        ResultService resultService3 = new ResultService();
        Assert.assertTrue(resultService3.getAll().isEmpty());
    }

}
