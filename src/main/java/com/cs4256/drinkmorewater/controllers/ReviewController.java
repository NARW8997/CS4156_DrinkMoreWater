package com.cs4256.drinkmorewater.controllers;

import com.cs4256.drinkmorewater.models.Review;
import com.cs4256.drinkmorewater.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    @RequestMapping(value = "/review/{review_id}", method = RequestMethod.GET)
    public ResponseEntity<?> getById(@PathVariable("review_id") int reviewId) {
        try {
            Review rev = reviewService.getReviewById(reviewId);

            return new ResponseEntity<>(rev, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("Error happened when getting review by id");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
