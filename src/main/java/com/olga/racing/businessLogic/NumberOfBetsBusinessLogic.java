package com.olga.racing.businessLogic;

import com.olga.racing.entity.Result;
import com.olga.racing.service.ResultService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class NumberOfBetsBusinessLogic {
    public static int numberOfBets() throws IOException {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        int iterator = 0;
        System.out.println("Введите количество ставок. Количество ставок ограничено до 50 включительно.");
        int n = 0;
        try {
            n = Integer.parseInt(buff.readLine());
            ResultService resultService = new ResultService();
            List<Result> resultServiceList = resultService.getAll();
            int sizeOfBets = resultServiceList.size();
            while (n < 0 || (n + sizeOfBets) > 50) {
                System.out.println("Введите число больше либо равное 0. Общее количество ставок должно быть меньше 50 включительно. Количество ставок сейчас = " + sizeOfBets);
                n = Integer.parseInt(buff.readLine());
                iterator++;
                if (iterator >= 2 && (n < 0 || (n + sizeOfBets) > 50)) {
                    System.out.println("Хотите не выполнять данную ставку? Её данные будут удалены. (Да\\Нет)");
                    String exitQuestion = buff.readLine();
                    if (exitQuestion.equalsIgnoreCase("Да")) {
                        SwitchActionBusinessLogic.switchActions();
                    }
                }
            }
            if (n == 0) {
                System.out.println("Вы выбрали 0 ставок. Программа завершена.");
                System.exit(0);
            }
        } catch (NumberFormatException e) {
            System.out.println("Вы ввели недопустимое число. Ставка не сделана.");
            SwitchActionBusinessLogic.switchActions();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return n;
    }
}
