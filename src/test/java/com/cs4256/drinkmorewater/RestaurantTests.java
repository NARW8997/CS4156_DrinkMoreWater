package com.cs4256.drinkmorewater;

import com.cs4256.drinkmorewater.mapper.RestaurantMapper;
import com.cs4256.drinkmorewater.models.Restaurant;
import com.cs4256.drinkmorewater.services.impl.RestaurantServiceImpl;
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
public class RestaurantTests {

    @Autowired
    private RestaurantServiceImpl restaurantServiceImpl;

    @MockBean
    private RestaurantMapper restaurantMapper;

    @Test
    public void testGetById() {
        int testId = 1;

        Restaurant retRestaurant = new Restaurant(1, "2957 Broadway, New York, NY 10025",
                "Shake Shack",0, 0, "900-222-1345", "medium");

        Mockito.when(restaurantMapper.selectById(testId)).thenReturn(retRestaurant);

        assertEquals(restaurantServiceImpl.getById(testId), retRestaurant);
    }

    @Test
    public void testGetAll() {
        List<Restaurant> restaurantList = Arrays.asList(
                new Restaurant(1, "2957 Broadway, New York, NY 10025", "Shake Shack",
                        0, 0, "900-222-1345", "medium"),
                new Restaurant(2, "2880 Broadway, New York, NY 10025", "Tom's", 1,
                        0, "809-223-4124", "small"));

        Mockito.when(restaurantMapper.selectList(null)).thenReturn(restaurantList);

        assertNotNull(restaurantServiceImpl.list());
    }

    @Test
    public void testUpdate() {
        Restaurant updateRestaurant = new Restaurant(1, "2957 Broadway, New York, NY 10025",
                "Shake Shack", 0, 0, "900-222-1345", "medium");

        Mockito.when(restaurantMapper.updateById(updateRestaurant)).thenReturn(1);

        assertTrue(restaurantServiceImpl.updateById(updateRestaurant));
    }

    @Test
    public void testInvalidUpdate() {
        Restaurant updateRestaurant = new Restaurant(-1, "2957 Broadway, New York, NY 10025",
                "Shake Shack", 0, 0, "900-222-1345", "medium");

        Mockito.when(restaurantMapper.updateById(updateRestaurant)).thenReturn(0);

        assertFalse(restaurantServiceImpl.updateById(updateRestaurant));
    }

    @Test
    public void testAddRestaurant() {
        Restaurant userToAdd = new Restaurant(2, "2957 Broadway, New York, NY 10025",
                "Shake Shack", 0, 0, "900-222-1345", "medium");

        Mockito.when(restaurantMapper.insert(userToAdd)).thenReturn(2);

        assertTrue(restaurantServiceImpl.save(userToAdd));
    }

    @Test
    public void testRemoveRestaurant() {
        int removeId = 2;

        Mockito.when(restaurantMapper.deleteById(removeId)).thenReturn(2);

        assertTrue(restaurantServiceImpl.removeById(removeId));
    }
}
