package com.finbox.tastysearch.services;

import com.finbox.tastysearch.comparators.ReviewComparator;
import com.finbox.tastysearch.configurations.ParametersProperties;
import com.finbox.tastysearch.models.Review;
import com.finbox.tastysearch.models.ScoreMetric;
import com.finbox.tastysearch.utils.ScoreUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

@Service
public class TopReviewsService {

    @Autowired
    private FileParser fileParser;

    @Autowired
    private ScoreUtils scoreUtils;

    @Autowired
    private ParametersProperties parametersProperties;

    public List<Review> getTopReviews(List<String> tokens) throws IOException {
        fileParser.initReviewList();

        int k = parametersProperties.getK();

        List<Review> reviewList = fileParser.getReviewList();
        Map<String, HashSet<Integer>> invertedIndex = fileParser.getInvertedIndex();

        PriorityQueue<ScoreMetric> minHeap = new PriorityQueue<ScoreMetric>(new ReviewComparator());

        for(int i=0;i<reviewList.size();i++){
            ScoreMetric scoreMetric = new ScoreMetric();

            scoreMetric.setDocID(i);
            scoreMetric.setGivenScore(reviewList.get(i).getScore());
            scoreMetric.setCalculatedScore(scoreUtils.scoreCalculator(invertedIndex, tokens, i));

            if(scoreMetric.getCalculatedScore() == 0.0f){
                continue;
            }

            if(k>0){
                k--;
                minHeap.add(scoreMetric);
            }else{
                if(minHeap.peek().getCalculatedScore()<scoreMetric.getCalculatedScore()){
                    minHeap.poll();
                    minHeap.add(scoreMetric);
                }else if(minHeap.peek().getCalculatedScore()==scoreMetric.getCalculatedScore() && minHeap.peek().getGivenScore()<scoreMetric.getGivenScore()){
                    minHeap.poll();
                    minHeap.add(scoreMetric);
                }
            }
        }

        List<Review> topReviews = new ArrayList<>();

        while(!minHeap.isEmpty()){
            topReviews.add(reviewList.get(minHeap.poll().getDocID()));
        }

        Collections.reverse(topReviews);

        return topReviews;
    }
}
