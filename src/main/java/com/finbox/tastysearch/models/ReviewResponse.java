package com.finbox.tastysearch.models;


import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReviewResponse {
    private List<Review> topReviews;
    private ReviewStatus responseStatus;

    public ReviewStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(ReviewStatus responseStatus) {
        this.responseStatus = responseStatus;
    }

    public List<Review> getTopReviews() {
        return topReviews;
    }

    public void setTopReviews(List<Review> topReviews) {
        this.topReviews = topReviews;
    }

    @Override
    public String toString() {
        return "ReviewResponse{" +
                "topReviews=" + topReviews +
                ", responseStatus=" + responseStatus +
                '}';
    }
}
