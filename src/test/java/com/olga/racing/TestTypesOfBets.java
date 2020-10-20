package com.olga.racing;

import com.olga.racing.service.TypesOfBetsService;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestTypesOfBets {

    @Test
    public void testGetAll() {
        TypesOfBetsService typesOfBetsService = new TypesOfBetsService();
        Assert.assertEquals(typesOfBetsService.getAll().size(),3);
    }
}

