package com.finbox.tastysearch.controllers;

import com.finbox.tastysearch.models.ReviewResponse;
import com.finbox.tastysearch.models.ReviewsRequest;
import com.finbox.tastysearch.services.TopReviewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class ReviewController {

    @Autowired
    private TopReviewsService topReviewsService;

    @PostMapping(path = "/getReviews", consumes = "application/json", produces = "application/json")
    public ReviewResponse getTopReviews(@RequestBody ReviewsRequest reviewsRequest) {
        ReviewResponse reviewResponse = new ReviewResponse();
        if(reviewsRequest != null && reviewsRequest.getTokens() != null){
            try {
                reviewResponse.setTopReviews(topReviewsService.getTopReviews(reviewsRequest.getTokens()));
            } catch (IOException e) {
                reviewResponse.setTopReviews(null);
            }
        }
        return reviewResponse;
    }
}
