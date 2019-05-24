package com.finbox.tastysearch.utils;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Map;

@Service
public class ScoreUtils {
    public float scoreCalculator(Map<String, HashSet<Integer>> invertedIndex, List<String> tokens, int docIndex){

        if(CollectionUtils.isEmpty(tokens)){
            return 0.0f;
        }

        float calculatedScore = 0.0f;

        for(String token:tokens){
            if(invertedIndex != null && invertedIndex.containsKey(token)){
                if(invertedIndex.get(token).contains(docIndex)){
                    calculatedScore += 1.0f;
                }
            }
        }

        calculatedScore /= (float) tokens.size();

        return calculatedScore;
    }
}
