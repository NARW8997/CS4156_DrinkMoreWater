package com.cs4256.drinkmorewater;

import com.cs4256.drinkmorewater.mapper.RevenueMapper;
import com.cs4256.drinkmorewater.models.Revenue;
import com.cs4256.drinkmorewater.services.impl.RevenueServiceImpl;
import lombok.NoArgsConstructor;
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
public class RevenueTests {

    @Autowired
    private RevenueServiceImpl revenueServiceImpl;

    @MockBean
    private RevenueMapper revenueMapper;

    @Test
    public void testGetById() {
        int testId = 1;

        Revenue retRevenue = new Revenue(1, 2021, 100, 200, 300, 200, 1);

        Mockito.when(revenueMapper.selectById(testId)).thenReturn(retRevenue);

        assertEquals(revenueServiceImpl.getById(testId), retRevenue);
    }

    @Test
    public void testGetByRestId() {
        int restId = 1;
        List<Revenue> retRevs = Arrays.asList(
                new Revenue(1, 2021, 100, 200, 300, 200, 1),
                new Revenue(2, 2021, 100, 200, 300, 200, 1)
        );

        Mockito.when(revenueMapper.selectRevenueByRestId(restId)).thenReturn(retRevs);

        assertNotNull(revenueServiceImpl.getRevenueByRestId(restId));
    }

    @Test
    public void testGetByRestIdAndYear() {
        int restId = 1;
        int year = 2021;
        Revenue retRevenue = new Revenue(1, 2021, 100, 200, 300, 200, 1);

        Mockito.when(revenueMapper.selectRevenueByRestIdAndYear(restId, year)).thenReturn(retRevenue);

        assertEquals(revenueServiceImpl.getRevenueByYear(restId, year), retRevenue);
    }

    @Test
    public void testGetAll() {
        List<Revenue> revenueList = Arrays.asList(
                new Revenue(1, 2021, 100, 200, 300, 200, 1),
                new Revenue(2, 2021, 1120, 1200, 400, 2450, 2));

        Mockito.when(revenueMapper.selectList(null)).thenReturn(revenueList);

        assertNotNull(revenueServiceImpl.list());
    }

    @Test
    public void testUpdate() {
        Revenue updateRevenue = new Revenue(1, 2021, 120, 230, 300, 200, 1);

        Mockito.when(revenueMapper.updateById(updateRevenue)).thenReturn(1);

        assertTrue(revenueServiceImpl.updateById(updateRevenue));
    }

    @Test
    public void testInvalidUpdate() {
        Revenue updateRevenue = new Revenue(-1, 2021, 100, 200, 300, 200, 1);

        Mockito.when(revenueMapper.updateById(updateRevenue)).thenReturn(0);

        assertFalse(revenueServiceImpl.updateById(updateRevenue));
    }

    @Test
    public void testAddRevenue() {
        Revenue revenueToAdd = new Revenue(1, 2021, 120, 230, 300, 200, 1);

        Mockito.when(revenueMapper.insert(revenueToAdd)).thenReturn(1);

        assertTrue(revenueServiceImpl.save(revenueToAdd));
    }

    @Test
    public void testRemoveRevenue() {
        int removeId = 2;

        Mockito.when(revenueMapper.deleteById(removeId)).thenReturn(1);

        assertTrue(revenueServiceImpl.removeById(removeId));
    }
}
