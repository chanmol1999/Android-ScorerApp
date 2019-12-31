package com.example.anmol.courtcounter.SaveResults;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "result_table")
public class Result {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String title;
    private String outcome;
    private String scoreOne;
    private String scoreTwo;
    private String scoreThree;
    private String scoreFour;
    private String scoreFive;

    public Result(String title, String outcome, String scoreOne, String scoreTwo, String scoreThree, String scoreFour, String scoreFive) {
        this.title = title;
        this.outcome = outcome;
        this.scoreOne = scoreOne;
        this.scoreTwo = scoreTwo;
        this.scoreThree = scoreThree;
        this.scoreFour = scoreFour;
        this.scoreFive = scoreFive;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getOutcome() {
        return outcome;
    }

    public String getScoreOne() {
        return scoreOne;
    }

    public String getScoreTwo() {
        return scoreTwo;
    }

    public String getScoreThree() {
        return scoreThree;
    }

    public String getScoreFour() {
        return scoreFour;
    }

    public String getScoreFive() {
        return scoreFive;
    }
}
