package com.finbox.tastysearch.models;


import java.util.List;

public class ReviewResponse {
    private List<Review> topReviews;

    public List<Review> getTopReviews() {
        return topReviews;
    }

    public void setTopReviews(List<Review> topReviews) {
        this.topReviews = topReviews;
    }
}
