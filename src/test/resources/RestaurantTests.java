package com.cs4256.drinkmorewater;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cs4256.drinkmorewater.mapper.DishMapper;
import com.cs4256.drinkmorewater.mapper.RestaurantMapper;
import com.cs4256.drinkmorewater.mapper.ReviewMapper;
import com.cs4256.drinkmorewater.models.Restaurant;
import com.cs4256.drinkmorewater.models.RestaurantDetail;
import com.cs4256.drinkmorewater.models.Review;
import com.cs4256.drinkmorewater.models.TopRankDish;
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

    @Test
    public void testGetRestDetail() {
        int restId = 1;
        List<Restaurant> restaurantList = Arrays.asList(
                new Restaurant(1, "2957 Broadway, New York, NY 10025", "Shake Shack",
                        2, 1, "900-222-1345", "medium", 1));
        RestaurantDetail detail = new RestaurantDetail(1, "2957 Broadway, New York, NY 10025", "Shake Shack",
                2, 1, "900-222-1345", "medium", 1, "John Doe");
        List<String> dishList = Arrays.asList("first dish", "second dish");
        List<String> reviewList = Arrays.asList("good review", "bad review");

        Mockito.when(restaurantMapper.selectList(null)).thenReturn(restaurantList);
        Mockito.when(restaurantMapper.selectRestDetailById(restId)).thenReturn(detail);
        Mockito.when(restaurantMapper.selectDishNameByRestId(restId)).thenReturn(reviewList);
        Mockito.when(restaurantMapper.selectReviewContentByRestId(restId)).thenReturn(dishList);

        assertNotNull(restaurantServiceImpl.selectAllRestDetail());
    }

    @Test
    public void testGetTopRankedDishesByRestId() {
        int restId = 1, rank = 10;
        List<TopRankDish> dishes = Arrays.asList(
                new TopRankDish(1, "name"),
                new TopRankDish(2, "another")
        );

        Mockito.when(restaurantMapper.selectTopRankOrderedDishesByRestId(restId, rank)).thenReturn(dishes);

        assertNotNull(restaurantServiceImpl.getTopRankOrderedDishesByRestId(restId, rank));
    }

    @Test
    public void testUpdate() {
        Restaurant updateRestaurant = new Restaurant(1, "2957 Broadway, New York, NY 10025",
                "Shake Shack", 0, 0, "900-222-1345", "medium",1);

        Mockito.when(restaurantMapper.updateById(updateRestaurant)).thenReturn(1);

        assertTrue(restaurantServiceImpl.updateById(updateRestaurant));
    }

    @Test
    public void testUpdateLikesAndDislikesByRestId() {
        int restId = 1, likes = 10, dislikes = 5;
        int updateSuccess = 1;

        Mockito.when(restaurantMapper.updateRestLikesByRestId(likes, restId)).thenReturn(updateSuccess);
        Mockito.when(restaurantMapper.updateRestDislikesByRestId(dislikes, restId)).thenReturn(updateSuccess);
        Mockito.when(restaurantMapper.updateRestLikesByRestIdBy1(restId)).thenReturn(updateSuccess);
        Mockito.when(restaurantMapper.updateRestDislikesByRestIdBy1(restId)).thenReturn(updateSuccess);

        assertEquals(restaurantServiceImpl.updateRestLikesByRestId(likes, restId), updateSuccess);
        assertEquals(restaurantServiceImpl.updateRestDislikesByRestId(dislikes, restId), updateSuccess);
        assertEquals(restaurantServiceImpl.updateRestLikesByRestIdBy1(restId), updateSuccess);
        assertEquals(restaurantServiceImpl.updateRestDislikesByRestIdBy1(restId), updateSuccess);
    }

    @Test
    public void testUpdateWithoutLikes() {
        int updateSuccess = 1;
        Restaurant rest = new Restaurant(1, "2957 Broadway, New York, NY 10025",
                "Shake Shack", 0, 0, "900-222-1345", "medium",1);
        rest.setRestLikes(null);
        rest.setRestDislikes(null);

        Mockito.when(restaurantMapper.updateExceptLikeAndDislike(rest)).thenReturn(updateSuccess);

        assertEquals(restaurantServiceImpl.updateExceptLikeAndDislike(rest), updateSuccess);
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
    public void testAddWithoutLikes() {
        int insertSuccess = 1;
        Restaurant rest = new Restaurant(2, "2957 Broadway, New York, NY 10025",
                "Shake Shack", 0, 0, "900-222-1345", "medium",1);
        rest.setRestLikes(null);
        rest.setRestDislikes(null);

        Mockito.when(restaurantMapper.insertExceptLikeAndDislike(rest)).thenReturn(insertSuccess);

        assertEquals(restaurantServiceImpl.insertExceptLikeAndDislike(rest), insertSuccess);
    }

    @Test
    public void testRemoveRestaurant() {
        int removeId = 2;

        Mockito.when(restaurantMapper.deleteById(removeId)).thenReturn(2);

        assertTrue(restaurantServiceImpl.removeById(removeId));
    }
}
