package com.cs4256.drinkmorewater;

import com.cs4256.drinkmorewater.models.OrderDish;
import com.cs4256.drinkmorewater.services.impl.OrderDishServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDishIntTests {
    @Autowired
    OrderDishServiceImpl orderDishServiceImpl;

    @Test
    public void testGet() {
        assertNotNull(orderDishServiceImpl.getById(1));
        assertNotNull(orderDishServiceImpl.list());
    }

    @Test
    public void testChange() {
        int retId;
        OrderDish orderDishToAdd = new OrderDish(0,  1, 1);

        assertTrue(orderDishServiceImpl.save(orderDishToAdd));
        retId = orderDishToAdd.getOrderedDishId();

        orderDishToAdd.setDishId(2);
        assertTrue(orderDishServiceImpl.updateById(orderDishToAdd));

        assertTrue(orderDishServiceImpl.removeById(retId));
        assertNull(orderDishServiceImpl.getById(retId));
    }
}
