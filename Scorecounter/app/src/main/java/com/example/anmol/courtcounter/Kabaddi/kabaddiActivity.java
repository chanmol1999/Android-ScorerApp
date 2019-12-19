package com.example.anmol.courtcounter.Kabaddi;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.anmol.courtcounter.Football.footballActivity;
import com.example.anmol.courtcounter.R;

public class kabaddiActivity extends AppCompatActivity {

    int scoreA = 0;
    int scoreB = 0;
    String winner = "";
    TextView scoreForTeamA;
    TextView scoreForTeamB;
    Button finishButton;
    Button reset;
    Button multiPointsA;
    Button multiPointsB;
    private int multiPoints = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kabaddi);

        scoreForTeamA = findViewById(R.id.team_a_score);
        scoreForTeamB = findViewById(R.id.team_b_score);
        finishButton = findViewById(R.id.finish);
        reset = findViewById(R.id.reset);
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
        multiPointsA = findViewById(R.id.multiPointsA);
        multiPointsB = findViewById(R.id.multiPointsB);

        multiPointsA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(kabaddiActivity.this);
                builder.setTitle("Multi-Points");
                final EditText input = new EditText(kabaddiActivity.this);
                input.setInputType(InputType.TYPE_CLASS_NUMBER);
                builder.setView(input);

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        multiPoints = Integer.parseInt(input.getText().toString());
                        scoreA += multiPoints;
                        displayScore();
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                builder.show();
            }
        });
        multiPointsB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(kabaddiActivity.this);
                builder.setTitle("Multi-Points");
                final EditText input = new EditText(kabaddiActivity.this);
                input.setInputType(InputType.TYPE_CLASS_NUMBER);
                builder.setView(input);

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        multiPoints = Integer.parseInt(input.getText().toString());
                        scoreB += multiPoints;
                        displayScore();
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                builder.show();
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
    public void allOutA(View view){
        scoreA +=2;
        displayScore();
    }
    public void teamBScore(View view) {
        scoreB += 1;
        displayScore();
    }
    public void allOutB(View view){
        scoreB += 2;
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
            Toast.makeText(kabaddiActivity.this, "Error occured", Toast.LENGTH_SHORT).show();
        }
        Alert();
    }
    public void reset(){
        scoreA = 0;
        scoreB = 0;
        displayScore();
    }
    public void Alert(){
        final android.app.AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Result: " + winner);
        builder.setMessage("Final Scoreline : " +"\n[Team A] : " + scoreA +" - "+scoreB+" : [Team B]");
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
}
