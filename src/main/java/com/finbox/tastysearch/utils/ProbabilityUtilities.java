package com.finbox.tastysearch.utils;

import com.finbox.tastysearch.configurations.ParametersProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class ProbabilityUtilities {

    @Autowired
    private ParametersProperties parametersProperties;

    public boolean getProbability(){

        int totalNoOfReviews = parametersProperties.getTotalReviews();
        int noOfReviewsToBeSampled = parametersProperties.getSampleReviews();
        int randomNo = parametersProperties.getProbabilityConstant();

        Random random = new Random();
        return random.nextInt(totalNoOfReviews/noOfReviewsToBeSampled) == randomNo;
    }
}
