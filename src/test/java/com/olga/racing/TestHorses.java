package com.olga.racing;

import com.olga.racing.service.HorsesService;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TestHorses {

    @Test
    public void testGetAll() {
        HorsesService horsesService = new HorsesService();
        Assert.assertEquals(horsesService.getAll().size(), 5);
    }

}

