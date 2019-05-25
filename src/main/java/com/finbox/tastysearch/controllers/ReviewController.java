package com.finbox.tastysearch.controllers;

import com.finbox.tastysearch.models.*;
import com.finbox.tastysearch.services.FileParser;
import com.finbox.tastysearch.services.TopReviewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class ReviewController {

    @Autowired
    private TopReviewsService topReviewsService;

    @Autowired
    private FileParser fileParser;

    @PostMapping(path = "/getReviews", consumes = "application/json", produces = "application/json")
    public ReviewResponse getTopReviews(@RequestBody ReviewsRequest reviewsRequest) {
        ReviewResponse reviewResponse = new ReviewResponse();
        if(reviewsRequest != null && reviewsRequest.getTokens() != null){
            try {
                reviewResponse.setTopReviews(topReviewsService.getTopReviews(reviewsRequest.getTokens()));
                if(reviewResponse.getTopReviews() != null && reviewResponse.getTopReviews().size()>0){
                    reviewResponse.setResponseStatus(ReviewStatus.SUCCESSFUL);
                }else{
                    reviewResponse.setTopReviews(null);
                    reviewResponse.setResponseStatus(ReviewStatus.NO_REVIEWS_FOUND);
                }
            } catch (IOException e) {
                reviewResponse.setResponseStatus(ReviewStatus.EXCEPTION_OCCURED);
                reviewResponse.setTopReviews(null);
            }
        }

        return reviewResponse;
    }

    @GetMapping(path = "/init", produces = "application/json")
    public InitResponse initializeInvertedIndex()
    {
        InitResponse initResponse = new InitResponse();
        try {
            fileParser.initReviewList();
            initResponse.setStatus(FileParserResponse.SUCCESSFUL);
        } catch (IOException e) {
            initResponse.setStatus(FileParserResponse.UNSUCCESSFUL);
        }

        return initResponse;
    }
}
