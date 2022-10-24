package com.cs4256.drinkmorewater;

import com.cs4256.drinkmorewater.mapper.ReviewMapper;
import com.cs4256.drinkmorewater.models.Review;
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
