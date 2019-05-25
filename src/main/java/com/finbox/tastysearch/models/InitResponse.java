package com.finbox.tastysearch.models;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class InitResponse {
    private FileParserResponse status;

    public FileParserResponse getStatus() {
        return status;
    }

    public void setStatus(FileParserResponse status) {
        this.status = status;
    }
}
