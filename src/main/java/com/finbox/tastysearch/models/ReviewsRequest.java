package com.finbox.tastysearch.models;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReviewsRequest {
    private List<String> tokens;

    public List<String> getTokens() {
        return tokens;
    }

    public void setTokens(List<String> tokens) {
        this.tokens = tokens;
    }

    @Override
    public String toString() {
        return "ReviewsRequest{" +
                "tokens=" + tokens +
                '}';
    }
}
