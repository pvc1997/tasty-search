package com.finbox.tastysearch.models;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public enum FileParserResponse {
    SUCCESSFUL, UNSUCCESSFUL;
}
