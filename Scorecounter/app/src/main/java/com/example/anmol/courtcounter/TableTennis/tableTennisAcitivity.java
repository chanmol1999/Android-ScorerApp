package com.example.anmol.courtcounter.TableTennis;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.anmol.courtcounter.R;

public class tableTennisAcitivity extends AppCompatActivity {

    int scoreA = 0;
    int scoreB = 0;
    int gameA = 0;
    int gameB = 0;
    int resetCounter = 0;

    TextView scoreForTeamA;
    TextView scoreForTeamB;
    TextView gameOneTeamA;
    TextView gameOneTeamB;
    TextView gameTwoTeamA;
    TextView gameTwoTeamB;
    TextView gameThreeTeamA;
    TextView gameThreeTeamB;
    TextView gameFourTeamA;
    TextView gameFourTeamB;
    TextView gameFiveTeamA;
    TextView gameFiveTeamB;
    TextView winnerTeam;
    RelativeLayout winnerMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_tennis_acitivity);

        scoreForTeamA = findViewById(R.id.team_a_score);
        scoreForTeamB = findViewById(R.id.team_b_score);
        gameOneTeamA = findViewById(R.id.game1_a);
        gameOneTeamB = findViewById(R.id.game1_b);
        gameTwoTeamA = findViewById(R.id.game2_a);
        gameTwoTeamB = findViewById(R.id.game2_b);
        gameThreeTeamA = findViewById(R.id.game3_a);
        gameThreeTeamB = findViewById(R.id.game3_b);
        gameFourTeamA = findViewById(R.id.game4_a);
        gameFourTeamB = findViewById(R.id.game4_b);
        gameFiveTeamA = findViewById(R.id.game5_a);
        gameFiveTeamB = findViewById(R.id.game5_b);
        winnerTeam = findViewById(R.id.winner_team);
        winnerMessage = findViewById(R.id.winner_message);




    }
    public void displayScore() {
        scoreForTeamA.setText(String.valueOf(scoreA));
        scoreForTeamB.setText(String.valueOf(scoreB));
    }
    public void teamAScore(View view) {
        scoreA += 1;
        checkGameWinner();
    }
    public void teamBScore(View view) {
        scoreB += 1;
        checkGameWinner();
    }
    public void updateTable() {
        if(gameA > 1 && gameB >1){
            gameFiveTeamA.setText(String.valueOf(scoreA));
            gameFiveTeamB.setText(String.valueOf(scoreB));
        }
        else if(gameA >1 || gameB >1){
            if(gameA==1 || gameB ==1){
                gameFourTeamA.setText(String.valueOf(scoreA));
                gameFourTeamB.setText(String.valueOf(scoreB));
        }
        else{
                gameThreeTeamA.setText(String.valueOf(scoreA));
                gameThreeTeamB.setText(String.valueOf(scoreB));
            }
        }
        else if (gameA > 0 && gameB > 0) {
            gameThreeTeamA.setText(String.valueOf(scoreA));
            gameThreeTeamB.setText(String.valueOf(scoreB));
        } else if (gameA > 0 || gameB > 0) {
            gameTwoTeamA.setText(String.valueOf(scoreA));
            gameTwoTeamB.setText(String.valueOf(scoreB));
        } else {
            gameOneTeamA.setText(String.valueOf(scoreA));
            gameOneTeamB.setText(String.valueOf(scoreB));
        }
        scoreA = 0;
        scoreB = 0;
    }
    public void winnerMessage() {
        if (gameA > 2) {
            winnerTeam.setText(R.string.team_a);
            winnerMessage.setVisibility(View.VISIBLE);
        }
        if (gameB > 2) {
            winnerTeam.setText(R.string.team_b);
            winnerMessage.setVisibility(View.VISIBLE);
        }
    }
    public void checkGameWinner() {
        if (scoreA > 29) {
            updateTable();
            gameA += 1;
            winnerMessage();
        } else if (scoreA > 10 && scoreA - scoreB > 1) {
            updateTable();
            gameA += 1;
            winnerMessage();
        }
        if (scoreB > 29) {
            updateTable();
            gameB += 1;
            winnerMessage();
        } else if (scoreB > 10 && scoreB - scoreA > 1) {
            updateTable();
            gameB += 1;
            winnerMessage();
        }
        displayScore();
    }
    public void resetScore(View view) {
        resetCounter += 1;
        if (resetCounter > 1) {
            scoreA = 0;
            scoreB = 0;
            gameA = 0;
            gameB = 0;
            displayScore();
            gameFiveTeamA.setText(String.valueOf(scoreA));
            gameFiveTeamB.setText(String.valueOf(scoreB));
            gameFourTeamA.setText(String.valueOf(scoreA));
            gameFourTeamB.setText(String.valueOf(scoreB));
            gameThreeTeamA.setText(String.valueOf(scoreA));
            gameThreeTeamB.setText(String.valueOf(scoreB));
            gameTwoTeamA.setText(String.valueOf(scoreA));
            gameTwoTeamB.setText(String.valueOf(scoreB));
            gameOneTeamA.setText(String.valueOf(scoreA));
            gameOneTeamB.setText(String.valueOf(scoreB));
            winnerMessage.setVisibility(View.INVISIBLE);
            resetCounter = 0;
        } else {

            Toast.makeText(this, R.string.reset_confirmation, Toast.LENGTH_SHORT).show();
        }
    }

}
