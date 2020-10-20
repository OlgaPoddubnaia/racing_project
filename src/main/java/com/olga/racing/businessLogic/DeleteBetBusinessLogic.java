
package com.olga.racing.businessLogic;

import com.olga.racing.entity.Result;
import com.olga.racing.service.ResultService;

import java.io.IOException;
import java.util.List;

public class DeleteBetBusinessLogic {
    public static void delBet(int id) throws IOException {
        ResultService resultService = new ResultService();
        List<Result> resultServiceList = resultService.getAll();
        int sizeOfBets = resultServiceList.size();
        if (id <= sizeOfBets) {
            ResultService resultServiceForRemove = new ResultService();
            resultServiceForRemove.removeById(id);
        } else {
            System.out.println("Вы ввели id, которого нет в списке ваших ставок. Вы перенаправляетесь в главное меню.");
            SwitchActionBusinessLogic.switchActions();
        }
    }
}

