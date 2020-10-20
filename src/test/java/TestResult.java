import com.olga.racing.entity.Result;
import com.olga.racing.service.ResultService;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TestResult {
    ResultService resultService = new ResultService();

    @Test
    public void testDelBet() {
        Result result = new Result();
        result.setId(2);
        result.setHorseId(2);
        result.setTypeOfBet("WIN");
        result.setMoney(200);
        resultService.add(result);
        System.out.println(resultService.getAll().toArray());
        int id = 1;
        resultService.removeById(id);
        System.out.println(resultService.getAll().toArray());
        Assert.assertEquals(resultService.getAll().contains(result), false);
    }

    @Test
    public void deleteAll() {
        //List<Result> resultList = new ArrayList<>();
        Result result1 = new Result();
        result1.setId(1);
        result1.setHorseId(2);
        result1.setTypeOfBet("WIN");
        result1.setMoney(200);
        //resultList.add(result1);

        Result result2 = new Result();
        result2.setId(2);
        result2.setHorseId(2);
        result2.setTypeOfBet("WIN");
        result2.setMoney(200);
        //resultList.add(result2);
        resultService.add(result1);
        resultService.add(result2);

        System.out.println(resultService.getAll().toString());
        resultService.deleteAll();

        System.out.println(resultService.getAll().toString());

        Assert.assertEquals(resultService.getAll().isEmpty(), true);
    }

    @Test
    public void add() {
        Result result1 = new Result();
        result1.setId(30);
        result1.setHorseId(2);
        result1.setTypeOfBet("WIN");
        result1.setMoney(200);
        resultService.add(result1);

    }

    @Test
    public void getAll() {
        System.out.println(resultService.getAll().size());
        Result result1 = new Result();
        result1.setId(2);
        result1.setHorseId(2);
        result1.setTypeOfBet("WIN");
        result1.setMoney(200);

        Result result2 = new Result();
        result2.setId(1);
        result2.setHorseId(2);
        result2.setTypeOfBet("WIN");
        result2.setMoney(200);

        resultService.add(result1);
        resultService.add(result2);
        System.out.println(resultService.getAll().size());

        Assert.assertEquals(resultService.getAll().size(), 2);
    }

}
