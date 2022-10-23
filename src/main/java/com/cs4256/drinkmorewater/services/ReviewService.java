package com.cs4256.drinkmorewater.services;

import com.cs4256.drinkmorewater.models.Review;
import com.cs4256.drinkmorewater.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public Review getReviewById(int reviewId) throws Exception {
        Optional<Review> result = reviewRepository.findById(reviewId);

        if (result.isPresent()) {
            return result.get();
        } else {
            throw new Exception("specified review not found!");
        }
    }

}
