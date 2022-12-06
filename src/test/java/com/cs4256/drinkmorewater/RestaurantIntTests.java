package com.cs4256.drinkmorewater;

import com.cs4256.drinkmorewater.models.Restaurant;
import com.cs4256.drinkmorewater.services.impl.RestaurantServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestaurantIntTests {
    @Autowired
    private RestaurantServiceImpl restaurantServiceImpl;

    @Test
    public void testGetAll() {
        assertNotNull(restaurantServiceImpl.list());
    }

    @Test
    public void testGetById() {
        int testId = 1;

        assertEquals(restaurantServiceImpl.getById(testId).getRestId(), testId);
    }

    @Test
    public void testGetPopular() {
        assertNotNull(restaurantServiceImpl.getPopularRestaurants());
    }

    @Test
    public void testGetRestDetail() {
        assertNotNull(restaurantServiceImpl.selectAllRestDetail());
    }

    @Test
    public void testGetTopRankedDishById() {
        int restId = 1, rank = 10;

        assertNotNull(restaurantServiceImpl.getTopRankOrderedDishesByRestId(restId, rank));
    }

    @Test
    public void testChangeRestaurantsExceptLikesAndDislikes() {
        int retVal;
        int retSuccess = 1;
        int retRestId;
        Restaurant rest = new Restaurant(0, "2957 Broadway, New York, NY 10025",
                "Shake Shack",0,0, "900-222-1345", "20",2);

        retVal = restaurantServiceImpl.insertExceptLikeAndDislike(rest);
        assertEquals(retVal, retSuccess);
        retRestId = rest.getRestId();

        rest.setRestName("Test Name Change");
        retVal = restaurantServiceImpl.updateExceptLikeAndDislike(rest);
        assertEquals(retVal, retSuccess);

        assertTrue(restaurantServiceImpl.removeById(retRestId));
        assertNull(restaurantServiceImpl.getById(retRestId));
    }

    @Test
    public void testChangeRestaurant() {
        int restId;
        int retSuccess = 1;
        Restaurant rest = new Restaurant(0, "2957 Broadway, New York, NY 10025",
                "Shake Shack",1,2, "900-222-1345", "20",2);

        assertTrue(restaurantServiceImpl.save(rest));
        restId = rest.getRestId();

        rest.setRestName("Test Name Change");
        assertTrue(restaurantServiceImpl.updateById(rest));
        assertEquals(restaurantServiceImpl.updateRestDislikesByRestId(1, restId), retSuccess);
        assertEquals(restaurantServiceImpl.updateRestLikesByRestId(1, restId), retSuccess);
        assertEquals(restaurantServiceImpl.updateRestLikesByRestIdBy1(restId), retSuccess);
        assertEquals(restaurantServiceImpl.updateRestDislikesByRestIdBy1(restId), retSuccess);

        assertTrue(restaurantServiceImpl.removeById(restId));
        assertNull(restaurantServiceImpl.getById(restId));
    }
}
