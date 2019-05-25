package com.finbox.tastysearch.models;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public enum ReviewStatus {
    NO_REVIEWS_FOUND, SUCCESSFUL, EXCEPTION_OCCURED;
}
