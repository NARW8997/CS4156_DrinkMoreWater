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
public class OrderProfileIntTests {
    @Autowired
    private OrderProfileServiceImpl orderProfileServiceImpl;

    @Test
    public void testGet() {
        assertNotNull(orderProfileServiceImpl.list());
        assertNotNull(orderProfileServiceImpl.getById(1));
    }

    @Test
    public void testChange() {
        int retId;
        Date date = new Date(2022-10-21);
        OrderProfile orderProfileToAdd = new OrderProfile(2, 1, 1, date, 50);

        assertTrue(orderProfileServiceImpl.save(orderProfileToAdd));
        retId = orderProfileToAdd.getOrderId();

        orderProfileToAdd.setRestId(3);
        assertTrue(orderProfileServiceImpl.updateById(orderProfileToAdd));

        assertTrue(orderProfileServiceImpl.removeById(retId));
        assertNull(orderProfileServiceImpl.getById(retId));
    }
}


