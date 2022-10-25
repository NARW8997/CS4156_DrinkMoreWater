package com.cs4256.drinkmorewater;

import com.cs4256.drinkmorewater.mapper.DishMapper;
import com.cs4256.drinkmorewater.models.Dish;
import com.cs4256.drinkmorewater.services.impl.DishServiceImpl;
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
public class DishTests {

    @Autowired
    private DishServiceImpl dishServiceImpl;

    @MockBean
    private DishMapper dishMapper;

    @Test
    public void testGetById() {
        int testId = 1;

        Dish retDish = new Dish(1, "Chinese authentic flavored vegetable fried white rice", "Spicy", "Vegan fried rice", "1", 1);

        Mockito.when(dishMapper.selectById(testId)).thenReturn(retDish);

        assertEquals(dishServiceImpl.getById(testId), retDish);
    }

    @Test
    public void testGetAll() {
        List<Dish> dishList = Arrays.asList(
                new Dish(1, "Chinese authentic flavored vegetable fried white rice", "Spicy", "Vegan fried rice", "1", 1),
                new Dish(2, "Traditional Mexican handmade roll with juicy beef", "Salty", "Beef burrito", "1", 2));

        Mockito.when(dishMapper.selectList(null)).thenReturn(dishList);

        assertNotNull(dishServiceImpl.list());
    }

    @Test
    public void testUpdate() {
        Dish updateDish = new Dish(1, "chao hao he", "Japan", "miso soup", "two people", 1);

        Mockito.when(dishMapper.updateById(updateDish)).thenReturn(1);

        assertTrue(dishServiceImpl.updateById(updateDish));
    }

    @Test
    public void testInvalidUpdate() {
        Dish updateDish = new Dish(-1, "Chinese authentic flavored vegetable fried white rice", "Spicy", "Vegan fried rice", "1", 1);

        Mockito.when(dishMapper.updateById(updateDish)).thenReturn(0);

        assertFalse(dishServiceImpl.updateById(updateDish));
    }

    @Test
    public void testAddDish() {
        Dish userToAdd = new Dish(2,"Chinese authentic flavored vegetable fried white rice", "Spicy", "Vegan fried rice", "1", 1);

        Mockito.when(dishMapper.insert(userToAdd)).thenReturn(2);

        assertTrue(dishServiceImpl.save(userToAdd));
    }

    @Test
    public void testRemoveDish() {
        int removeId = 2;

        Mockito.when(dishMapper.deleteById(removeId)).thenReturn(2);

        assertTrue(dishServiceImpl.removeById(removeId));
    }
}
