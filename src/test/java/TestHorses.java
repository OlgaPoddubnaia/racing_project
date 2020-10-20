import com.olga.racing.entity.Horses;
import com.olga.racing.entity.Result;
import com.olga.racing.service.HorsesService;
import com.olga.racing.service.ResultService;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TestHorses {
    HorsesService horsesService = new HorsesService();

    public void testGetAll() {
        Horses horses = new Horses();
        horses.setId(1);
        horses.getHorseName();

        horsesService.getAll();

    }

}

