package com.finbox.tastysearch.services;

import com.finbox.tastysearch.configurations.ParametersProperties;
import com.finbox.tastysearch.models.Review;
import com.finbox.tastysearch.utils.ProbabilityUtilities;
import com.finbox.tastysearch.utils.StringUtilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

@Service
public class FileParser {

    @Autowired
    private ProbabilityUtilities probability;

    @Autowired
    private StringUtilities stringUtilities;

    @Autowired
    private ParametersProperties parametersProperties;

    private List<Review> reviewList;
    private Map<String, HashSet<Integer>> invertedIndex;

    public void initReviewList() throws IOException {
        if(reviewList == null && invertedIndex == null){

            String filePath = parametersProperties.getFilepath();
            int count = -1;

            try (BufferedReader reader = new BufferedReader(new java.io.FileReader(filePath))) {

                reviewList = new ArrayList<>();
                invertedIndex = new HashMap<String, HashSet<Integer>>();

                String line = reader.readLine();
                while (line != null) {
                    if(probability.getProbability()){
                        count++;

                        Review review = new Review();
                        review.setProductId(line.substring(line.indexOf(' ')+1));
                        line = reader.readLine();
                        review.setUserId(line.substring(line.indexOf(' ')+1));
                        line = reader.readLine();
                        review.setProfileName(line.substring(line.indexOf(' ')+1));
                        line = reader.readLine();

                        if (!line.contains(": ")) {
                            line = reader.readLine();
                        }

                        review.setHelpfulness(line.substring(line.indexOf(' ')+1));
                        line = reader.readLine();
                        review.setScore(Float.parseFloat(line.substring(line.indexOf(' ')+1)));
                        line = reader.readLine();
                        review.setTime(Long.parseLong(line.substring(line.indexOf(' ')+1)));
                        line = reader.readLine();
                        review.setSummary(line.substring(line.indexOf(' ')+1));
                        line = reader.readLine();
                        review.setText(line.substring(line.indexOf(' ')+1));
                        reader.readLine();
                        line = reader.readLine();

                        updateInvertedIndex(review.getText(), count);
                        updateInvertedIndex(review.getSummary(), count);

                        reviewList.add(review);
                    }else{
                        line = reader.readLine();
                        line = reader.readLine();
                        line = reader.readLine();

                        if (!line.contains(": ")) {
                            line = reader.readLine();
                        }

                        line = reader.readLine();
                        line = reader.readLine();
                        line = reader.readLine();
                        line = reader.readLine();
                        reader.readLine();
                        line = reader.readLine();
                    }
                }
            }
        }
    }

    private void updateInvertedIndex(String text, int docIndex){
        List<String> tokens = stringUtilities.tokenizeString(text);

        for(String token: tokens){
            if(invertedIndex.containsKey(token)){
                invertedIndex.get(token).add(docIndex);
            }else{
                HashSet<Integer> docSet = new HashSet<>();
                docSet.add(docIndex);
                invertedIndex.put(token, docSet);
            }
        }
    }

    public List<Review> getReviewList() {
        return reviewList;
    }

    public Map<String, HashSet<Integer>> getInvertedIndex() {
        return invertedIndex;
    }
}
