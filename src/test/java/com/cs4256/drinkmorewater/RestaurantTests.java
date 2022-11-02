package com.cs4256.drinkmorewater;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cs4256.drinkmorewater.mapper.DishMapper;
import com.cs4256.drinkmorewater.mapper.RestaurantMapper;
import com.cs4256.drinkmorewater.mapper.ReviewMapper;
import com.cs4256.drinkmorewater.models.Dish;
import com.cs4256.drinkmorewater.models.Restaurant;
import com.cs4256.drinkmorewater.models.Review;
import com.cs4256.drinkmorewater.services.impl.RestaurantServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
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

    @MockBean
    private DishMapper dishMapper;

    @MockBean
    private ReviewMapper reviewMapper;

    @Test
    public void testGetById() {
        int testId = 1;

        Restaurant retRestaurant = new Restaurant(1, "2957 Broadway, New York, NY 10025",
                "Shake Shack",0, 0, "900-222-1345", "medium", 1);

        Mockito.when(restaurantMapper.selectById(testId)).thenReturn(retRestaurant);

        assertEquals(restaurantServiceImpl.getById(testId), retRestaurant);
    }

    @Test
    public void testGetAll() {
        List<Restaurant> restaurantList = Arrays.asList(
                new Restaurant(1, "2957 Broadway, New York, NY 10025", "Shake Shack",
                        0, 0, "900-222-1345", "medium", 1),
                new Restaurant(2, "2880 Broadway, New York, NY 10025", "Tom's", 1,
                        0, "809-223-4124", "small", 1));

        Mockito.when(restaurantMapper.selectList(null)).thenReturn(restaurantList);

        assertNotNull(restaurantServiceImpl.list());
    }

    @Test
    public void testGetPopular() {
        List<Restaurant> restaurantList = Arrays.asList(
                new Restaurant(1, "2957 Broadway, New York, NY 10025", "Shake Shack",
                        2, 1, "900-222-1345", "medium", 1),
                new Restaurant(2, "2880 Broadway, New York, NY 10025", "Tom's", 1,
                        0, "809-223-4124", "small", 1));
        QueryWrapper<Review> qw1 = new QueryWrapper<Review>();
        QueryWrapper<Review> qw2 = new QueryWrapper<Review>();
        qw1.ge("rest_id", 1);
        qw2.ge("rest_id", 2);

        Mockito.when(restaurantMapper.selectList(null)).thenReturn(restaurantList);
        Mockito.when(reviewMapper.selectCount(qw1)).thenReturn(2);
        Mockito.when(reviewMapper.selectCount(qw1)).thenReturn(1);

        assertNotNull(restaurantServiceImpl.getPopularRestaurants());
    }

//    @Test
//    public void testGetRestDetail() {
//        List<Restaurant> restaurantList = Arrays.asList(
//                new Restaurant(1, "2957 Broadway, New York, NY 10025", "Shake Shack",
//                        2, 1, "900-222-1345", "medium"));
//        List<Dish> dishList = Arrays.asList(
//                new Dish(1, "some dish", "spicy", "toufu", "12", 1),
//                new Dish(2, "some dish", "mild", "random", "10", 1)
//        );
//        List<Review> reviewList = Arrays.asList(
//                new Review(1, "good restaurant", 1, 1),
//                new Review(2, "average", 1, 2)
//        );
//        LambdaQueryWrapper<Dish> dishQueryWrapper = new LambdaQueryWrapper<>();
//        dishQueryWrapper.select(Dish::getDishName)
//                .eq(Dish::getRestId, 1);
//        LambdaQueryWrapper<Review> reviewQueryWrapper = new LambdaQueryWrapper<>();
//        reviewQueryWrapper.select(Review::getContent)
//                .eq(Review::getRestId, 1);
//
//        Mockito.when(restaurantMapper.selectList(null)).thenReturn(restaurantList);
//        Mockito.when(dishMapper.selectList(dishQueryWrapper)).thenReturn(dishList);
//        Mockito.when(reviewMapper.selectList(reviewQueryWrapper)).thenReturn(reviewList);
//
//        assertNotNull(restaurantServiceImpl.selectAllRestDetail());
//    }

    @Test
    public void testUpdate() {
        Restaurant updateRestaurant = new Restaurant(1, "2957 Broadway, New York, NY 10025",
                "Shake Shack", 0, 0, "900-222-1345", "medium",1);

        Mockito.when(restaurantMapper.updateById(updateRestaurant)).thenReturn(1);

        assertTrue(restaurantServiceImpl.updateById(updateRestaurant));
    }

    @Test
    public void testInvalidUpdate() {
        Restaurant updateRestaurant = new Restaurant(-1, "2957 Broadway, New York, NY 10025",
                "Shake Shack", 0, 0, "900-222-1345", "medium",1);

        Mockito.when(restaurantMapper.updateById(updateRestaurant)).thenReturn(0);

        assertFalse(restaurantServiceImpl.updateById(updateRestaurant));
    }

    @Test
    public void testAddRestaurant() {
        Restaurant userToAdd = new Restaurant(2, "2957 Broadway, New York, NY 10025",
                "Shake Shack", 0, 0, "900-222-1345", "medium",1);

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
