package com.cs4256.drinkmorewater;

import com.cs4256.drinkmorewater.mapper.ReviewMapper;
import com.cs4256.drinkmorewater.models.Review;
import com.cs4256.drinkmorewater.models.UserRestReview;
import com.cs4256.drinkmorewater.services.impl.ReviewServiceImpl;
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
public class ReviewTests {

    @Autowired
    private ReviewServiceImpl reviewServiceImpl;

    @MockBean
    private ReviewMapper reviewMapper;

    @Test
    public void testGetById() {
        int testId = 1;

        Review retReview = new Review(1, "Good service!", 1, 1);

        Mockito.when(reviewMapper.selectById(testId)).thenReturn(retReview);

        assertEquals(reviewServiceImpl.getById(testId), retReview);
    }

    @Test
    public void testGetUserRestReviewByUserId() {
        int userId = 1;
        List<UserRestReview> urReviews = Arrays.asList(
                new UserRestReview("John", "restName", "Good Restaurant"),
                new UserRestReview("John", "rest2", "Bad Restaurant")
        );

        Mockito.when(reviewMapper.selectUserRestReviewByUserId(userId)).thenReturn(urReviews);

        assertNotNull(reviewServiceImpl.selectUserRestReviewByUserId(userId));
    }

    @Test
    public void testGetUserRestReviewByRestId() {
        int restId = 1;
        List<UserRestReview> urReviews = Arrays.asList(
                new UserRestReview("John", "rest1", "Good Restaurant"),
                new UserRestReview("Joe", "rest1", "Bad Restaurant")
        );

        Mockito.when(reviewMapper.selectUserRestReviewByRestId(restId)).thenReturn(urReviews);

        assertNotNull(reviewServiceImpl.selectUserRestReviewByRestId(restId));
    }

    @Test
    public void testGetAll() {
        List<Review> reviewList = Arrays.asList(
                new Review(1, "Good service!", 1, 1),
                new Review(2, "Yummy food!", 2, 1));

        Mockito.when(reviewMapper.selectList(null)).thenReturn(reviewList);

        assertNotNull(reviewServiceImpl.list());
    }

    @Test
    public void testUpdate() {
        Review updateReview = new Review(1, "Good service!", 1, 1);

        Mockito.when(reviewMapper.updateById(updateReview)).thenReturn(1);

        assertTrue(reviewServiceImpl.updateById(updateReview));
    }

    @Test
    public void testInvalidUpdate() {
        Review updateReview = new Review(-1, "Good service!", 1, 1);

        Mockito.when(reviewMapper.updateById(updateReview)).thenReturn(0);

        assertFalse(reviewServiceImpl.updateById(updateReview));
    }

    @Test
    public void testAddReview() {
        Review reviewToAdd = new Review(2, "Good service!", 1, 1);

        Mockito.when(reviewMapper.insert(reviewToAdd)).thenReturn(2);

        assertTrue(reviewServiceImpl.save(reviewToAdd));
    }

    @Test
    public void testRemoveReview() {
        int removeId = 2;

        Mockito.when(reviewMapper.deleteById(removeId)).thenReturn(2);

        assertTrue(reviewServiceImpl.removeById(removeId));
    }
}
