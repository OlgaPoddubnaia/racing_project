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
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        //удаление ставок предыдущего человека
        ResultService resultService = new ResultService();
        resultService.deleteAll();

        racingBets(num());

        switchActions();
    }

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
                            switchActions();
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
                            switchActions();
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
                            switchActions();
                        }
                    }
                }
                iterator = 0;
                result.setMoney(money);

                resultService.add(result);
            }
        } catch (NumberFormatException e) {
            System.out.println("Вы ввели недопустимое число. Ставка не сделана.");
            switchActions();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int num() throws IOException {
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
                        switchActions();
                    }
                }
            }
            if (n == 0) {
                System.out.println("Вы выбрали 0 ставок. Программа завершена.");
                System.exit(0);
            }
        } catch (NumberFormatException e) {
            System.out.println("Вы ввели недопустимое число. Ставка не сделана.");
            switchActions();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return n;
    }

    public static void delBet(int id) {
        ResultService resultService1 = new ResultService();
        resultService1.remove(id);
    }

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
                delBet(Integer.parseInt(buff.readLine()));
                switchActions();
            case "UPD":
                racingBets(num());
                switchActions();
            default:
                System.out.println("Введите один из вариантов: LIST, STOP, DEL, UPD.");
                switchActions();
        }
    }
}
