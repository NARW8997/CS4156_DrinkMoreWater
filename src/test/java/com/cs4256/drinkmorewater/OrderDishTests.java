package com.cs4256.drinkmorewater;

import com.cs4256.drinkmorewater.mapper.OrderDishMapper;
import com.cs4256.drinkmorewater.models.OrderDish;
import com.cs4256.drinkmorewater.services.impl.OrderDishServiceImpl;
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
public class OrderDishTests {

    @Autowired
    private OrderDishServiceImpl orderDishServiceImpl;

    @MockBean
    private OrderDishMapper orderDishMapper;

    @Test
    public void testGetById() {
        int testId = 1;

        OrderDish retOrderDish = new OrderDish(1, 1, 1);

        Mockito.when(orderDishMapper.selectById(testId)).thenReturn(retOrderDish);

        assertEquals(orderDishServiceImpl.getById(testId), retOrderDish);
    }

    @Test
    public void testGetAll() {
        List<OrderDish> orderDishList = Arrays.asList(
                new OrderDish(1, 1, 1),
                new OrderDish(2, 1, 2));

        Mockito.when(orderDishMapper.selectList(null)).thenReturn(orderDishList);

        assertNotNull(orderDishServiceImpl.list());
    }

    @Test
    public void testUpdate() {
        OrderDish updateOrderDish = new OrderDish(1, 1, 2);

        Mockito.when(orderDishMapper.updateById(updateOrderDish)).thenReturn(1);

        assertTrue(orderDishServiceImpl.updateById(updateOrderDish));
    }

    @Test
    public void testInvalidUpdate() {
        OrderDish updateOrderDish = new OrderDish(-1, 1, 1);

        Mockito.when(orderDishMapper.updateById(updateOrderDish)).thenReturn(0);

        assertFalse(orderDishServiceImpl.updateById(updateOrderDish));
    }

    @Test
    public void testAddOrderDish() {
        OrderDish orderDishToAdd = new OrderDish(2,  1, 1);

        Mockito.when(orderDishMapper.insert(orderDishToAdd)).thenReturn(2);

        assertTrue(orderDishServiceImpl.save(orderDishToAdd));
    }

    @Test
    public void testRemoveOrderDish() {
        int removeId = 2;

        Mockito.when(orderDishMapper.deleteById(removeId)).thenReturn(2);

        assertTrue(orderDishServiceImpl.removeById(removeId));
    }
}
