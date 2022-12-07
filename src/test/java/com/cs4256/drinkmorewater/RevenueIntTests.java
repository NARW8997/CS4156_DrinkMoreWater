package com.cs4256.drinkmorewater;
import com.cs4256.drinkmorewater.mapper.RevenueMapper;
import com.cs4256.drinkmorewater.models.Revenue;
import com.cs4256.drinkmorewater.services.impl.RevenueServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RevenueIntTests {
    @Autowired
    private RevenueServiceImpl revenueServiceImpl;

    @Test
    public void testGet() {
        assertNotNull(revenueServiceImpl.list());
        assertNotNull(revenueServiceImpl.getRevenueByRestId(1));
        assertEquals(revenueServiceImpl.getById(1).getRevenueId(), 1);

        Revenue retRev = revenueServiceImpl.getRevenueByYear(1, 2021);
        assertEquals(retRev.getRestId(), 1);
        assertEquals(retRev.getRevenueYear(), 2021);
    }

    @Test
    public void testChange() {
        int retId;
        Revenue revenueToAdd = new Revenue(1, 2021, 120, 230, 300, 200, 1);

        assertTrue(revenueServiceImpl.save(revenueToAdd));
        retId = revenueToAdd.getRevenueId();

        revenueToAdd.setQ1(250);
        assertTrue(revenueServiceImpl.updateById(revenueToAdd));

        assertTrue(revenueServiceImpl.removeById(retId));
        assertNull(revenueServiceImpl.getById(retId));
    }
}
