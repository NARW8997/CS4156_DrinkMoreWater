package com.cs4256.drinkmorewater;

import com.cs4256.drinkmorewater.mapper.OrderProfileMapper;
import com.cs4256.drinkmorewater.models.OrderProfile;
import com.cs4256.drinkmorewater.services.impl.OrderProfileServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderProfileTests {

    @Autowired
    private OrderProfileServiceImpl orderProfileServiceImpl;

    @MockBean
    private OrderProfileMapper orderProfileMapper;

    @Test
    public void testGetById() {
        int testId = 1;
        Date date = new Date(2022-10-21);
        OrderProfile retOrderProfile = new OrderProfile(1, 1, 1, date, 50);

        Mockito.when(orderProfileMapper.selectById(testId)).thenReturn(retOrderProfile);

        assertEquals(orderProfileServiceImpl.getById(testId), retOrderProfile);
    }

    @Test
    public void testGetAll() {
        Date date = new Date(2022-10-21);
        List<OrderProfile> orderProfileList = Arrays.asList(
                new OrderProfile(1, 1, 1, date, 50),
                new OrderProfile(2, 2, 1, date, 30));

        Mockito.when(orderProfileMapper.selectList(null)).thenReturn(orderProfileList);

        assertNotNull(orderProfileServiceImpl.list());
    }

    @Test
    public void testUpdate() {
        Date date = new Date(2022-10-21);
        OrderProfile updateOrderProfile = new OrderProfile(1, 1, 1, date, 50);

        Mockito.when(orderProfileMapper.updateById(updateOrderProfile)).thenReturn(1);

        assertTrue(orderProfileServiceImpl.updateById(updateOrderProfile));
    }

    @Test
    public void testInvalidUpdate() {
        Date date = new Date(2022-10-21);
        OrderProfile updateOrderProfile = new OrderProfile(-1, 1, 1, date, 50);

        Mockito.when(orderProfileMapper.updateById(updateOrderProfile)).thenReturn(0);

        assertFalse(orderProfileServiceImpl.updateById(updateOrderProfile));
    }

    @Test
    public void testAddOrderProfile() {
        Date date = new Date(2022-10-21);
        OrderProfile orderProfileToAdd = new OrderProfile(2, 1, 1, date, 50);

        Mockito.when(orderProfileMapper.insert(orderProfileToAdd)).thenReturn(2);

        assertTrue(orderProfileServiceImpl.save(orderProfileToAdd));
    }

    @Test
    public void testRemoveOrderProfile() {
        int removeId = 2;

        Mockito.when(orderProfileMapper.deleteById(removeId)).thenReturn(2);

        assertTrue(orderProfileServiceImpl.removeById(removeId));
    }
}
