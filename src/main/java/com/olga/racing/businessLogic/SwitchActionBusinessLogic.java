package com.olga.racing.businessLogic;

import com.olga.racing.entity.Result;
import com.olga.racing.service.ResultService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class SwitchActionBusinessLogic {
    public static void switchActions() throws IOException {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        System.out.printf("%nВыберете дальнейшие действия: %n" +
                "Если вы хотите посмотреть список выших ставок, то введите LIST%n" +
                "Если вы хотите закончить работу приложения, то введите STOP %n" +
                "Если вы хотите удалить ставку, то введите DEL%n" +
                "Если вы хотите добавить ставки, то введите UPD%n");
        String switchString = buff.readLine();
        switch (switchString) {
            case "LIST":
                System.out.println("Список ваших ставок:");
                ResultService resultService = new ResultService();
                List<Result> resultServiceList = resultService.getAll();
                for (Result printResult : resultServiceList) {
                    System.out.println(printResult);
                }
                System.out.println();
                switchActions();
            case "STOP":
                System.out.println("Вы выбрали завершить работу приложения.");
                buff.close();
                System.exit(0);
            case "DEL":
                System.out.println("Введите номер id ставки, которую вы хотите удалить.");
                DeleteBetBusinessLogic.delBet(Integer.parseInt(buff.readLine()));
                switchActions();
            case "UPD":
                RacingBetsBusinessLogic.racingBets(NumberOfBetsBusinessLogic.numberOfBets());
                switchActions();
            default:
                System.out.println("Введите один из вариантов: LIST, STOP, DEL, UPD.");
                switchActions();
        }
    }
}
