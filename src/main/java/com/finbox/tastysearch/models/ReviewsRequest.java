package com.finbox.tastysearch.models;

import java.util.List;

public class ReviewsRequest {
    private List<String> tokens;

    public List<String> getTokens() {
        return tokens;
    }

    public void setTokens(List<String> tokens) {
        this.tokens = tokens;
    }
}
