package com.finbox.tastysearch.utils;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;

@Service
public class StringUtilities {
    public List<String> tokenizeString(String text){
        List<String> tokens = new ArrayList<>();

        if(StringUtils.isEmpty(text)){
            return tokens;
        }

        BreakIterator iterator = BreakIterator.getWordInstance();
        iterator.setText(text);

        int start = iterator.first();
        for (int end = iterator.next(); end != BreakIterator.DONE; start = end, end = iterator.next()) {
            tokens.add(text.substring(start, end).toLowerCase());
        }

        return tokens;
    }
}
