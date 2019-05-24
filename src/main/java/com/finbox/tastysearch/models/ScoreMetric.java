package com.finbox.tastysearch.models;

public class ScoreMetric {
    private int docID;
    private float calculatedScore;
    private float givenScore;

    public int getDocID() {
        return docID;
    }

    public void setDocID(int docID) {
        this.docID = docID;
    }

    public float getCalculatedScore() {
        return calculatedScore;
    }

    public void setCalculatedScore(float calculatedScore) {
        this.calculatedScore = calculatedScore;
    }

    public float getGivenScore() {
        return givenScore;
    }

    public void setGivenScore(float givenScore) {
        this.givenScore = givenScore;
    }
}
