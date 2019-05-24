package com.finbox.tastysearch.configurations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(name = "parametersProperties", value = "parameters.properties")
public class ParametersProperties {

    @Value("${k}")
    private int k;

    @Value("${totalReviews}")
    private int totalReviews;

    @Value("${sampleReviews}")
    private int sampleReviews;

    @Value("${filepath}")
    private String filepath;

    @Value("${probabilityConstant}")
    private int probabilityConstant;

    public int getK() {
        return k;
    }

    public void setK(int k) {
        this.k = k;
    }

    public int getTotalReviews() {
        return totalReviews;
    }

    public void setTotalReviews(int totalReviews) {
        this.totalReviews = totalReviews;
    }

    public int getSampleReviews() {
        return sampleReviews;
    }

    public void setSampleReviews(int sampleReviews) {
        this.sampleReviews = sampleReviews;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public int getProbabilityConstant() {
        return probabilityConstant;
    }

    public void setProbabilityConstant(int probabilityConstant) {
        this.probabilityConstant = probabilityConstant;
    }
}
