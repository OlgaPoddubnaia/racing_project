package com.olga.racing.businessLogic;

import com.olga.racing.service.ResultService;

import java.io.IOException;


public class Main {

    public static void main(String[] args) throws IOException {
        ResultService resultService = new ResultService();
        resultService.deleteAll();
        RacingBetsBusinessLogic.racingBets(NumberOfBetsBusinessLogic.numberOfBets());
        SwitchActionBusinessLogic.switchActions();
    }
}
