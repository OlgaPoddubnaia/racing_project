package com.olga.racing.businessLogic;

import com.olga.racing.entity.Horses;
import com.olga.racing.entity.Result;
import com.olga.racing.entity.TypesOfBets;
import com.olga.racing.service.HorsesService;
import com.olga.racing.service.ResultService;
import com.olga.racing.service.TypesOfBetsService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class RacingBetsBusinessLogic {
    public static void racingBets(int numOfBets) throws IOException {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        int iterator = 0;
        //цикл для каждой ставки
        try {
            for (int i = 0; i < numOfBets; i++) {
                System.out.println();
                if (i != 0) System.out.println("Оставшееся количество ставок: " + (numOfBets - i));

                ResultService resultService = new ResultService();
                Result result = new Result();

                System.out.println("Ознакомьтесь с таблицей гонки");
                HorsesService horsesService = new HorsesService();
                List<Horses> horses = horsesService.getAll();
                for (Horses h : horses
                ) {
                    System.out.println(h);
                }
                System.out.println();

                System.out.println("Ознакомьтесь с типами ставок");
                TypesOfBetsService typesOfBetsService = new TypesOfBetsService();
                List<TypesOfBets> types = typesOfBetsService.getAll();
                for (TypesOfBets t : types) {
                    System.out.println(t);
                }
                System.out.println();

                System.out.println("Выберете лошадь для ставки по id");
                int id = Integer.parseInt(buff.readLine());
                while (!(id >= 1 && id <= 5)) {
                    System.out.println("Введите id лошади из диапозона 1-5 включительно");
                    id = Integer.parseInt(buff.readLine());
                    iterator++;
                    if (iterator >= 2 && !(id >= 1 && id <= 5)) {
                        System.out.println("Хотите не выполнять данную ставку? Её данные будут удалены. (Да\\Нет)");
                        String exitQuestion = buff.readLine();
                        if (exitQuestion.equalsIgnoreCase("Да")) {
                            SwitchActionBusinessLogic.switchActions();
                        }
                    }
                }
                iterator = 0;
                result.setHorseId(id);

                System.out.println("Введите тип ставки ЗАГЛАВНЫМИ БУКВАМИ, как он указан в таблице");
                String type = buff.readLine();
                while (!(type.equals("WIN") || type.equals("PLACE") || type.equals("SHOW"))) {
                    System.out.println("Введите тип ставки из трёх возможных: WIN, PLACE, SHOW");
                    type = buff.readLine();
                    iterator++;
                    if (iterator >= 2) {
                        System.out.println("Хотите не выполнять данную ставку? Её данные будут удалены. (Да\\Нет)");
                        String exitQuestion = buff.readLine();
                        if (exitQuestion.equalsIgnoreCase("Да")) {
                            SwitchActionBusinessLogic.switchActions();
                        }
                    }
                }
                iterator = 0;
                result.setTypeOfBet(type);

                System.out.println("Введите сумму, которую хотите поставить. Максимальный размер одной ставки 2.000.000.000 включительно");
                int money = Integer.parseInt(buff.readLine());
                while (money <= 0 || money >= 2000000000) {
                    System.out.println("Введите сумму больше нуля и меньше 2.000.000.000");
                    money = Integer.parseInt(buff.readLine());
                    iterator++;
                    if (iterator >= 2 && (money <= 0 || money >= 2000000000)) {
                        System.out.println("Хотите не выполнять данную ставку? Её данные будут удалены. (Да\\Нет)");
                        String exitQuestion = buff.readLine();
                        if (exitQuestion.equalsIgnoreCase("Да")) {
                            SwitchActionBusinessLogic.switchActions();
                        }
                    }
                }
                iterator = 0;
                result.setMoney(money);

                resultService.add(result);
            }
        } catch (NumberFormatException e) {
            System.out.println("Вы ввели недопустимое число. Ставка не сделана.");
            SwitchActionBusinessLogic.switchActions();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
