package com.cs4256.drinkmorewater;

import com.cs4256.drinkmorewater.models.Dish;
import com.cs4256.drinkmorewater.services.impl.DishServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DishIntTests {
    @Autowired
    private DishServiceImpl dishServiceImpl;

    @Test
    public void testGet() {
        assertNotNull(dishServiceImpl.list());
        assertNotNull(dishServiceImpl.getById(1));
    }

    @Test
    public void testDishChange() {
        int retId;
        Dish dish = new Dish(1, "Chinese authentic flavored vegetable fried white rice", "Spicy", "Vegan fried rice", "1", 1);

        assertTrue(dishServiceImpl.save(dish));
        retId = dish.getDishId();

        dish.setDishName("change name");
        assertTrue(dishServiceImpl.updateById(dish));

        assertTrue(dishServiceImpl.removeById(retId));
        assertNull(dishServiceImpl.getById(retId));
    }
}
