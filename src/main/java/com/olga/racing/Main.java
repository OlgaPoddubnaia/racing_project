package com.olga.racing;

import com.olga.racing.entity.Horses;
import com.olga.racing.entity.Result;
import com.olga.racing.entity.TypesOfBets;
import com.olga.racing.service.HorsesService;
import com.olga.racing.service.ResultService;
import com.olga.racing.service.TypesOfBetsService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        //показать все ставки
      /*  TypesOfBetsService typesOfBetsService = new TypesOfBetsService();
        List<TypesOfBets> types = typesOfBetsService.getAll();
        for (TypesOfBets t : types) {
            System.out.println(t);
        }*/

        //показать список всех лошадей
      /*  HorsesService horsesService = new HorsesService();
        List<Horses> horses = horsesService.getAll();
        for (Horses h : horses
        ) {
            System.out.println(h);
        }*/

        //показать лошадь по id
        /*HorsesService horsesService2 = new HorsesService();
        Horses horses1 = horsesService2.getByID(4);
        System.out.println(horses1);*/

        //внести данные в result
         /* ResultService resultService = new ResultService();
         Result result1 = new Result();
      result1.setId(1);
        result1.setHorseId(2);
        result1.setTypeOfBet("WIN");
        result1.setMoney(200);
        resultService.add(result1);*/

        //печать списка ставок
     /*  List<Result> resultServiceList = resultService.getAll();
        for (Result printResult : resultServiceList) {
            System.out.println(printResult);
        }*/


       /*
       //убрать ставку


        ResultService resultService = new ResultService();
       resultService.remove(1);
        ResultService resultService = new ResultService();
        resultService.remove(2);
        ResultService resultService = new ResultService();
        resultService.remove(3);
        ResultService resultService2 = new ResultService();

        resultService2.remove(4);*/


        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите количество ставок ");
        int n = Integer.parseInt(buff.readLine());
        while (n < 0) {
            System.out.println("Введите число больше либо равное 0 ");
            n = Integer.parseInt(buff.readLine());
        }

        //цикл для каждй ставки
        for (int i = 0; i < n; i++) {
            if (i != 0) System.out.println("Оставшееся количество ставок: " + (n - i));

            //тут внести в таблицу результата id
            ResultService resultService = new ResultService();
            Result result = new Result();
            result.setId(i + 1);

            System.out.println("Ознакомьтесь с таблицей гонки");
            HorsesService horsesService = new HorsesService();
            List<Horses> horses = horsesService.getAll();
            for (Horses h : horses
            ) {
                System.out.println(h);
            }


            System.out.println("Ознакомьтесь с типами ставок");
            TypesOfBetsService typesOfBetsService = new TypesOfBetsService();
            List<TypesOfBets> types = typesOfBetsService.getAll();
            for (TypesOfBets t : types) {
                System.out.println(t);
            }
            System.out.println("Выберете лошадь для ставки по id");
            int id = Integer.parseInt(buff.readLine());
            result.setHorseId(id);

            System.out.println("Введите тип ставки как он указан в таблице");
            String type = buff.readLine();
            while (!type.equals("WIN") || !type.equals("PLACE") || !type.equals("SHOW")) {
                System.out.println("Введите тип ставки из трёх возможных: WIN, PLACE, SHOW");
                type = buff.readLine();
            }
            result.setTypeOfBet(type);

            System.out.println("Введите сумму, которую хотите поставить");
            int money = Integer.parseInt(buff.readLine());
            while (money <= 0) {
                System.out.println("Введите сумму больше нуля");
                money = Integer.parseInt(buff.readLine());
            }
            result.setMoney(money);
            resultService.add(result);
        }

        System.out.println("Показать список ваших ставок? (Да/Нет)");
        String showBets = buff.readLine();
        while (!showBets.equalsIgnoreCase("Да") || !showBets.equalsIgnoreCase("Нет")) {
            System.out.println("Введите один из вариантов ответов: Да или Нет");
            showBets = buff.readLine();
        }
        if (showBets.equalsIgnoreCase("Да")) {
            System.out.println("Список ваших ставок:");
            ResultService resultService = new ResultService();
            List<Result> resultServiceList = resultService.getAll();
            for (Result printResult : resultServiceList) {
                System.out.println(printResult);
            }
        }


        buff.close();
    }
}
