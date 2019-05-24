package com.finbox.tastysearch.comparators;

import com.finbox.tastysearch.models.ScoreMetric;
import org.springframework.stereotype.Service;

import java.util.Comparator;

public class ReviewComparator implements Comparator<ScoreMetric> {
    @Override
    public int compare(ScoreMetric reviewA, ScoreMetric reviewB) {
        if(reviewA.getCalculatedScore()>reviewB.getCalculatedScore()){
            return 1;
        }else if(reviewA.getCalculatedScore()<reviewB.getCalculatedScore()){
            return -1;
        }else{
            if(reviewA.getGivenScore()>reviewB.getGivenScore()){
                return 1;
            }else if(reviewA.getGivenScore()<reviewB.getGivenScore()){
                return -1;
            }
        }
        return 0;
    }
}
