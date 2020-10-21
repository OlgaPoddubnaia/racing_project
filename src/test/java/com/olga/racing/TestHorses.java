package com.olga.racing;

import com.olga.racing.entity.Horses;
import com.olga.racing.service.HorsesService;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TestHorses {

    @Test(priority = 1)
    public void testAdd() {
        Horses horses = new Horses();
        horses.setId(10);
        horses.setHorseName("Leila");
        horses.setAge(8);
        horses.setWeight("11-0");
        horses.setRating(9);
        horses.setCoefficient((float) 1.2);

        HorsesService horsesService = new HorsesService();
        System.out.println("Проверка наличия horses в таблице до добавления. Резульатат = " + horsesService.getAll().contains(horses));

        HorsesService horsesService1 = new HorsesService();
        horsesService1.add(horses);

        HorsesService horsesService2 = new HorsesService();

        Assert.assertTrue(horsesService2.getAll().contains(horses));
    }

    @Test(priority = 2)
    public void testGetAll() {
        Horses horses = new Horses();
        horses.setId(11);
        horses.setHorseName("Sasha");
        horses.setAge(7);
        horses.setWeight("10-8");
        horses.setRating((float) 8.7);
        horses.setCoefficient((float) 1.4);

        HorsesService horsesService = new HorsesService();
        System.out.println("Проверка наличия horses в таблице до добавления. Резульатат = " + horsesService.getAll().contains(horses));

        HorsesService horsesService1 = new HorsesService();
        horsesService1.add(horses);

        HorsesService horsesService2 = new HorsesService();
        Assert.assertTrue(horsesService2.getAll().contains(horses));
    }

    @Test(priority = 3)
    public void testDeleteById() {
        Horses horses = new Horses();
        horses.setId(12);
        horses.setHorseName("Hanna");
        horses.setAge(9);
        horses.setWeight("10-9");
        horses.setRating((float) 9.3);
        horses.setCoefficient((float) 1.7);

        HorsesService horsesService = new HorsesService();
        System.out.println("Проверка наличия horses в таблице до добавления. Резульатат = " + horsesService.getAll().contains(horses));

        HorsesService horsesService1 = new HorsesService();
        horsesService1.add(horses);

        HorsesService horsesService2 = new HorsesService();
        System.out.println("Проверка наличия horses в таблице после добавления. Резульатат = " + horsesService2.getAll().contains(horses));

        HorsesService horsesService3 = new HorsesService();
        horsesService3.removeById(12);
        //удаляем резульат getAll и add
        HorsesService horsesService4 = new HorsesService();
        horsesService4.removeById(10);
        HorsesService horsesService5 = new HorsesService();
        horsesService5.removeById(11);

        HorsesService horsesService6 = new HorsesService();
        Assert.assertFalse(horsesService6.getAll().contains(horses));
    }

}

