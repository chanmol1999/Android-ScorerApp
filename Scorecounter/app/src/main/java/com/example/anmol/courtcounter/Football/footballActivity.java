package com.example.anmol.courtcounter.Football;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.anmol.courtcounter.R;

public class footballActivity extends AppCompatActivity {

    int scoreA = 0;
    int scoreB = 0;
    String winner = "";
    TextView scoreForTeamA;
    TextView scoreForTeamB;
    Button finishButton;
    Button reset;
    Button redCard_teamA;
    Button redCard_teamB;
    Button yellowCard_teamA;
    Button yellowCard_teamB;
    int redCountA = 0 ;
    int redCountB = 0 ;
    int yellowCountA = 0 ;
    int yellowCountB = 0 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_football);
        scoreForTeamA = findViewById(R.id.team_a_score);
        scoreForTeamB = findViewById(R.id.team_b_score);
        finishButton = findViewById(R.id.finish);
        reset = findViewById(R.id.reset);
        redCard_teamA = findViewById(R.id.redCard_TeamA);
        redCard_teamB = findViewById(R.id.redCard_TeamB);
        yellowCard_teamA = findViewById(R.id.yellowCard_TeamA);
        yellowCard_teamB = findViewById(R.id.yellowCard_TeamB);

        redCard_teamA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redCardA();
            }
        });

        redCard_teamB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redCardB();
            }
        });

        yellowCard_teamA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                yellowCardA();
            }
        });

        yellowCard_teamB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                yellowCardB();
            }
        });

        finishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkGameWinner();
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reset();
            }
        });
    }
    public void displayScore() {
        scoreForTeamA.setText(String.valueOf(scoreA));
        scoreForTeamB.setText(String.valueOf(scoreB));
    }
    public void teamAScore(View view) {
        scoreA += 1;
        displayScore();
    }
    public void teamBScore(View view) {
        scoreB += 1;
        displayScore();
    }
    public void checkGameWinner() {
        if(scoreA > scoreB){
            winner = "Team A wins!";
        }
        else if(scoreB > scoreA) {
            winner = "Team B wins!";
        }
        else if(scoreA == scoreB){
            winner = "It's a Tie!";
        }
        else {
            Toast.makeText(footballActivity.this, "Error occured", Toast.LENGTH_SHORT).show();
        }
        Alert();
    }
    public void reset(){
        scoreA = 0;
        scoreB = 0;
        displayScore();
        redCountA = 0;
        redCountB =0;
        yellowCountA = 0;
        yellowCountB = 0;
    }
    public void Alert(){
        final android.app.AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Result : " + winner);
        builder.setMessage("Final score line : "+scoreA +"-"+scoreB+"\n"+"\nRed Cards for Team A = " + redCountA + "\nRed Cards for Team B = "+redCountB+"\nYellow card for Team A = "+yellowCountA + "\nYellow card for Team B = "+ yellowCountB);

        builder.setPositiveButton("Play Again?", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                reset();
            }
        });
        builder.setNegativeButton("Exit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
    public void redCardA(){

        if(redCountA>10){
            Toast.makeText(this, "Team A Red Card limit reached", Toast.LENGTH_SHORT).show();
        }
        else {
            redCountA += 1;
            Toast.makeText(this, "Team A Red Card : "+ String.valueOf(redCountA), Toast.LENGTH_SHORT).show();
        }
    }
    public void redCardB(){

        if(redCountB>10){
            Toast.makeText(this, "Team B Red Card limit reached", Toast.LENGTH_SHORT).show();
        }
        else {
            redCountB += 1;
            Toast.makeText(this, "Team B Red Card : "+ String.valueOf(redCountB), Toast.LENGTH_SHORT).show();
        }
    }
    public void yellowCardA(){

        if(yellowCountA>10){
            Toast.makeText(this, "Team A Yellow Card limit reached", Toast.LENGTH_SHORT).show();
        }
        else {
            yellowCountA += 1;
            Toast.makeText(this, "Team A Yellow Card : "+ String.valueOf(yellowCountA), Toast.LENGTH_SHORT).show();
        }
    }
    public void yellowCardB(){
        if(yellowCountB>10){
            Toast.makeText(this, "Team B Yellow Card limit reached", Toast.LENGTH_SHORT).show();
        }
        else {
            yellowCountB += 1;
            Toast.makeText(this, "Team B Yellow Card : "+ String.valueOf(yellowCountB), Toast.LENGTH_SHORT).show();
        }
    }
}
