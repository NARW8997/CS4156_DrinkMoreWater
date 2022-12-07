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
public class ReviewIntTests {
    @Autowired
    private ReviewServiceImpl reviewServiceImpl;

    @Test
    public void testGet() {
        assertNotNull(reviewServiceImpl.list());
        assertNotNull(reviewServiceImpl.getById(1));
        assertNotNull(reviewServiceImpl.selectUserRestReviewByUserId(1));
        assertNotNull(reviewServiceImpl.selectUserRestReviewByRestId(1));
    }

    @Test
    public void testChange() {
        int retId;
        Review reviewToAdd = new Review(0, "Good service!", 1, 1);

        assertTrue(reviewServiceImpl.save(reviewToAdd));
        retId = reviewToAdd.getReviewId();

        reviewToAdd.setContent("chang contents");
        assertTrue(reviewServiceImpl.updateById(reviewToAdd));

        assertTrue(reviewServiceImpl.removeById(retId));
        assertNull(reviewServiceImpl.getById(retId));
    }
}
