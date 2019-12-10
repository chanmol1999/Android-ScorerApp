package com.example.anmol.courtcounter.Cricket;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


import com.example.anmol.courtcounter.R;

public class CricketActivity extends AppCompatActivity {

    private int scoreTeamA;
    private int ballTeamA = 1;
    private int overTeamA = 0;
    private int scoreTeamB;
    private int ballTeamB = 1;
    private int overTeamB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cricket);

        scoreTeamA = 0;
        scoreTeamB = 0;
        (findViewById(R.id.team_a_ball_1)).setBackgroundResource(R.color.colorSuccess);
        (findViewById(R.id.team_b_ball_1)).setBackgroundResource(R.color.colorSuccess);
    }
    public void addRunsTeamA(View view) {
        TextView runField = findViewById(R.id.team_a_runs);
        int score = Integer.parseInt(runField.getText().toString());
        scoreTeamA += score;
        runField.setText("0");
        displayOverScoreTeamA(score);
        displayScoreTeamA(scoreTeamA);
    }
    public void incrementRunsTeamA(View view) {
        TextView runField = findViewById(R.id.team_a_runs);
        int score = Integer.parseInt(runField.getText().toString());
        score += 1;
        runField.setText("" + score);
    }
    public void decrementRunsTeamA(View view) {
        TextView runField = findViewById(R.id.team_a_runs);
        int score = Integer.parseInt(runField.getText().toString());
        if (score > 0) score -= 1;
        runField.setText("" + score);
    }
    public void addFourTeamA(View view) {
        scoreTeamA += 4;
        displayOverScoreTeamA(4);
        displayScoreTeamA(scoreTeamA);
    }
    public void addSixTeamA(View view) {
        scoreTeamA += 6;
        displayOverScoreTeamA(6);
        displayScoreTeamA(scoreTeamA);
    }
    public void outTeamA(View view) {
        displayOverScoreTeamA(-1);

    }
    private void displayOverScoreTeamA(int score) {
        String displayScore;
        TextView currentView = null;
        TextView swap = null;
        if (score == -1)
            displayScore = "O";
        else
            displayScore = "" + score;
        switch (ballTeamA) {
            case 1:
                currentView = findViewById(R.id.team_a_ball_1);
                findViewById(R.id.team_a_ball_2).setBackgroundResource(R.color.colorSuccess);
                break;
            case 2:
                currentView = findViewById(R.id.team_a_ball_2);
                findViewById(R.id.team_a_ball_3).setBackgroundResource(R.color.colorSuccess);
                break;
            case 3:
                currentView = findViewById(R.id.team_a_ball_3);
                findViewById(R.id.team_a_ball_4).setBackgroundResource(R.color.colorSuccess);
                break;
            case 4:
                currentView = findViewById(R.id.team_a_ball_4);
                findViewById(R.id.team_a_ball_5).setBackgroundResource(R.color.colorSuccess);
                break;
            case 5:
                currentView = findViewById(R.id.team_a_ball_5);
                findViewById(R.id.team_a_ball_6).setBackgroundResource(R.color.colorSuccess);
                break;
            case 6:
                currentView = findViewById(R.id.team_a_ball_6);
                break;
            case 7:
                currentView = findViewById(R.id.team_a_ball_1);
                swap = findViewById(R.id.team_a_ball_2);
                swap.setText("0");
                swap.setBackgroundResource(R.color.colorSuccess);
                swap = findViewById(R.id.team_a_ball_3);
                swap.setText("0");
                swap.setBackgroundResource(R.color.colorGray300);
                swap = findViewById(R.id.team_a_ball_4);
                swap.setText("0");
                swap.setBackgroundResource(R.color.colorGray300);
                swap = findViewById(R.id.team_a_ball_5);
                swap.setText("0");
                swap.setBackgroundResource(R.color.colorGray300);
                swap = findViewById(R.id.team_a_ball_6);
                swap.setText("0");
                swap.setBackgroundResource(R.color.colorGray300);
                ballTeamA = 1;
                overTeamA++;
        }
        currentView.setText(displayScore);
        if (displayScore.equalsIgnoreCase("o")) {
            currentView.setBackgroundResource(R.color.colorDanger);
            swap = findViewById(R.id.team_a_wickets);
            swap.setText(String.format("%d", Integer.parseInt(swap.getText().toString()) + 1));
        } else currentView.setBackgroundResource(R.color.colorGray500);
        swap = findViewById(R.id.team_a_over);
        if (ballTeamA != 6)
            swap.setText(String.format("%d.%d", overTeamA, ballTeamA));
        else
            swap.setText(String.format("%d", overTeamA + 1));
        ballTeamA++;
    }
    private void displayScoreTeamA(int score) {
        TextView scoreField = findViewById(R.id.team_a_score);
        scoreField.setText("" + score);
    }
    public void addRunsTeamB(View view) {
        TextView runField = findViewById(R.id.team_b_runs);
        int score = Integer.parseInt(runField.getText().toString());
        scoreTeamB += score;
        runField.setText("0");
        displayOverScoreTeamB(score);
        displayScoreTeamB(scoreTeamB);
    }
    public void incrementRunsTeamB(View view) {
        TextView runField = findViewById(R.id.team_b_runs);
        int score = Integer.parseInt(runField.getText().toString());
        score += 1;
        runField.setText("" + score);
    }
    public void decrementRunsTeamB(View view) {
        TextView runField = findViewById(R.id.team_b_runs);
        int score = Integer.parseInt(runField.getText().toString());
        if (score > 0) score -= 1;
        runField.setText("" + score);
    }
    public void addFourTeamB(View view) {
        scoreTeamB += 4;
        displayOverScoreTeamB(4);
        displayScoreTeamB(scoreTeamB);
    }
    public void addSixTeamB(View view) {
        scoreTeamB += 6;
        displayOverScoreTeamB(6);
        displayScoreTeamB(scoreTeamB);
    }
    public void outTeamB(View view) {
        displayOverScoreTeamB(-1);
    }

    private void displayOverScoreTeamB(int score) {
        String displayScore;
        TextView currentView = null;
        TextView swap = null;
        if (score == -1)
            displayScore = "O";
        else
            displayScore = "" + score;
        switch (ballTeamB) {
            case 1:
                currentView = findViewById(R.id.team_b_ball_1);
                findViewById(R.id.team_b_ball_2).setBackgroundResource(R.color.colorSuccess);
                break;
            case 2:
                currentView = findViewById(R.id.team_b_ball_2);
                findViewById(R.id.team_b_ball_3).setBackgroundResource(R.color.colorSuccess);
                break;
            case 3:
                currentView = findViewById(R.id.team_b_ball_3);
                findViewById(R.id.team_b_ball_4).setBackgroundResource(R.color.colorSuccess);
                break;
            case 4:
                currentView = findViewById(R.id.team_b_ball_4);
                findViewById(R.id.team_b_ball_5).setBackgroundResource(R.color.colorSuccess);
                break;
            case 5:
                currentView = findViewById(R.id.team_b_ball_5);
                findViewById(R.id.team_b_ball_6).setBackgroundResource(R.color.colorSuccess);
                break;
            case 6:
                currentView = findViewById(R.id.team_b_ball_6);
                break;
            case 7:
                currentView = findViewById(R.id.team_b_ball_1);
                swap = findViewById(R.id.team_b_ball_2);
                swap.setText("0");
                swap.setBackgroundResource(R.color.colorSuccess);
                swap = findViewById(R.id.team_b_ball_3);
                swap.setText("0");
                swap.setBackgroundResource(R.color.colorGray300);
                swap = findViewById(R.id.team_b_ball_4);
                swap.setText("0");
                swap.setBackgroundResource(R.color.colorGray300);
                swap = findViewById(R.id.team_b_ball_5);
                swap.setText("0");
                swap.setBackgroundResource(R.color.colorGray300);
                swap = findViewById(R.id.team_b_ball_6);
                swap.setText("0");
                swap.setBackgroundResource(R.color.colorGray300);
                ballTeamB = 1;
                overTeamB++;
        }
        currentView.setText(displayScore);
        if (displayScore.equalsIgnoreCase("o")) {
            currentView.setBackgroundResource(R.color.colorDanger);
            swap = findViewById(R.id.team_b_wickets);
            swap.setText(String.format("%d", Integer.parseInt(swap.getText().toString()) + 1));
        } else currentView.setBackgroundResource(R.color.colorGray500);
        swap = findViewById(R.id.team_b_over);
        if (ballTeamB != 6)
            swap.setText(String.format("%d.%d", overTeamB, ballTeamB));
        else
            swap.setText(String.format("%d", overTeamB + 1));
        ballTeamB++;
    }
    private void displayScoreTeamB(int score) {
        TextView scoreField = findViewById(R.id.team_b_score);
        scoreField.setText("" + score);
    }
    public void reset(View view) {
        // Reset Scores
        ((TextView) findViewById(R.id.team_a_score)).setText("0");
        ((TextView) findViewById(R.id.team_b_score)).setText("0");
        scoreTeamA = 0;
        scoreTeamB = 0;

        // Reset Over
        ((TextView) findViewById(R.id.team_a_over)).setText("0");
        ((TextView) findViewById(R.id.team_b_over)).setText("0");
        overTeamA = 0;
        overTeamB = 0;
        ballTeamA = 1;
        ballTeamB = 1;

        //Reset Wickets
        ((TextView) findViewById(R.id.team_a_wickets)).setText("0");
        ((TextView) findViewById(R.id.team_b_wickets)).setText("0");

        // Reset Team A over scores
        ((TextView) findViewById(R.id.team_a_ball_1)).setText("0");
        ((TextView) findViewById(R.id.team_a_ball_2)).setText("0");
        ((TextView) findViewById(R.id.team_a_ball_3)).setText("0");
        ((TextView) findViewById(R.id.team_a_ball_4)).setText("0");
        ((TextView) findViewById(R.id.team_a_ball_5)).setText("0");
        ((TextView) findViewById(R.id.team_a_ball_6)).setText("0");
        findViewById(R.id.team_a_ball_1).setBackgroundResource(R.color.colorSuccess);
        findViewById(R.id.team_a_ball_2).setBackgroundResource(R.color.colorGray300);
        findViewById(R.id.team_a_ball_3).setBackgroundResource(R.color.colorGray300);
        findViewById(R.id.team_a_ball_4).setBackgroundResource(R.color.colorGray300);
        findViewById(R.id.team_a_ball_5).setBackgroundResource(R.color.colorGray300);
        findViewById(R.id.team_a_ball_6).setBackgroundResource(R.color.colorGray300);

        // Reset Team B over scores
        ((TextView) findViewById(R.id.team_b_ball_1)).setText("0");
        ((TextView) findViewById(R.id.team_b_ball_2)).setText("0");
        ((TextView) findViewById(R.id.team_b_ball_3)).setText("0");
        ((TextView) findViewById(R.id.team_b_ball_4)).setText("0");
        ((TextView) findViewById(R.id.team_b_ball_5)).setText("0");
        ((TextView) findViewById(R.id.team_b_ball_6)).setText("0");
        findViewById(R.id.team_b_ball_1).setBackgroundResource(R.color.colorSuccess);
        findViewById(R.id.team_b_ball_2).setBackgroundResource(R.color.colorGray300);
        findViewById(R.id.team_b_ball_3).setBackgroundResource(R.color.colorGray300);
        findViewById(R.id.team_b_ball_4).setBackgroundResource(R.color.colorGray300);
        findViewById(R.id.team_b_ball_5).setBackgroundResource(R.color.colorGray300);
        findViewById(R.id.team_b_ball_6).setBackgroundResource(R.color.colorGray300);
    }
}


