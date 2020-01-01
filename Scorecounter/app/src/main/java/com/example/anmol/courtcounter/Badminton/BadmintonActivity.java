package com.example.anmol.courtcounter.Badminton;

import android.content.DialogInterface;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.anmol.courtcounter.Basketball.BasketballActivity;
import com.example.anmol.courtcounter.R;
import com.example.anmol.courtcounter.SaveResults.Result;
import com.example.anmol.courtcounter.SaveResults.ResultViewModel;

public class BadmintonActivity extends AppCompatActivity {

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
    TextView teamAHeading;
    TextView teamBHeading;
    Button resetButton;
    String SetOneA;
    String SetOneB;
    String SetTwoA;
    String SetTwoB;
    String SetThreeA;
    String SetThreeB;
    String result;
    ResultViewModel resultViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_badminton);

        resultViewModel = ViewModelProviders.of(this).get(ResultViewModel.class);
        scoreForTeamA = findViewById(R.id.team_a_score);
        scoreForTeamB = findViewById(R.id.team_b_score);
        gameOneTeamA = findViewById(R.id.game1_a);
        gameOneTeamB = findViewById(R.id.game1_b);
        gameTwoTeamA = findViewById(R.id.game2_a);
        gameTwoTeamB = findViewById(R.id.game2_b);
        gameThreeTeamA = findViewById(R.id.game3_a);
        gameThreeTeamB = findViewById(R.id.game3_b);
        resetButton = findViewById(R.id.resetB);
        teamAHeading = findViewById(R.id.TeamA_Textview);
        teamBHeading = findViewById(R.id.TeamB_Textview);
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetScore();
            }
        });

        teamAHeading.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertBuilder = new AlertDialog.Builder( BadmintonActivity.this );
                alertBuilder.setTitle( "Edit Team Name" );

                final EditText input = new EditText( BadmintonActivity.this );
                input.setInputType( InputType.TYPE_CLASS_TEXT );
                alertBuilder.setView( input );
                alertBuilder.setPositiveButton( "Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        teamAHeading.setText( input.getText() );
                    }
                } );
                alertBuilder.setNegativeButton( "Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                } );
                alertBuilder.show();
            }
        } );

        teamBHeading.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertBuilder = new AlertDialog.Builder( BadmintonActivity.this );
                alertBuilder.setTitle( "Edit Team Name" );

                final EditText input = new EditText( BadmintonActivity.this );
                input.setInputType( InputType.TYPE_CLASS_TEXT );
                alertBuilder.setView( input );
                alertBuilder.setPositiveButton( "Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        teamBHeading.setText( input.getText() );
                    }
                } );
                alertBuilder.setNegativeButton( "Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                } );
                alertBuilder.show();
            }
        } );

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
        if (gameA > 0 && gameB > 0) {
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
        if (gameA > 1) {
            AlertDialog.Builder dialog = new AlertDialog.Builder(this);
            dialog.setTitle("Winner : TEAM A");
            result = "Winner : TEAM A";
            SetOneA = gameOneTeamA.getText().toString();
            SetOneB = gameOneTeamB.getText().toString();
            SetTwoA = gameTwoTeamA.getText().toString();
            SetTwoB = gameTwoTeamB.getText().toString();
            SetThreeA = gameThreeTeamA.getText().toString();
            SetThreeB =gameThreeTeamB.getText().toString();


            dialog.setMessage("Final Scoreline : \n"
                            +"\n[Team A] " + gameOneTeamA.getText().toString() +" - "+gameOneTeamB.getText().toString()+" [Team B]"+"\t (Set-1)"
                            +"\n[Team A] " + gameTwoTeamA.getText().toString() +" - "+gameTwoTeamB.getText().toString()+" [Team B]"+"\t (Set-2)"
                            +"\n[Team A] " + gameThreeTeamA.getText().toString() +" - "+gameThreeTeamB.getText().toString()+" [Team B]"+"\t (Set-3)");
            resetScore();
           dialog.setNegativeButton("Play Again?", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    // User clicked the "Keep editing" button, so dismiss the dialog
                    // and continue editing the pet.
                    if (dialog != null) {
                        resetScore();
                        dialog.dismiss();
                    }
                }
            });
           dialog.setPositiveButton("Exit", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    // User clicked the "Keep editing" button, so dismiss the dialog
                    // and continue editing the pet.
                    if (dialog != null) {
                        finish();

                    }
                }
            });
           dialog.setNeutralButton("Save and Exit", new DialogInterface.OnClickListener() {
               @Override
               public void onClick(DialogInterface dialogInterface, int i) {
                   addItems();
                   finish();
               }
           });
            AlertDialog alertDialog = dialog.create();
            dialog.show();}
        if (gameB > 1) {
            AlertDialog.Builder dialog = new AlertDialog.Builder(this);
            dialog.setTitle("Winner : TEAM B");
            result = "Winner : TEAM B";
            SetOneA = gameOneTeamA.getText().toString();
            SetOneB = gameOneTeamB.getText().toString();
            SetTwoA = gameTwoTeamA.getText().toString();
            SetTwoB = gameTwoTeamB.getText().toString();
            SetThreeA = gameThreeTeamA.getText().toString();
            SetThreeB =gameThreeTeamB.getText().toString();
            dialog.setMessage("Final Scoreline : \n"

                    +"\n[Team A] " + gameOneTeamA.getText().toString() +" - "+gameOneTeamB.getText().toString()+" [Team B]"+"\t (Set-1)"
                    +"\n[Team A] " + gameTwoTeamA.getText().toString() +" - "+gameTwoTeamB.getText().toString()+" [Team B]"+"\t (Set-2)"
                    +"\n[Team A] " + gameThreeTeamA.getText().toString() +" - "+gameThreeTeamB.getText().toString()+" [Team B]"+"\t (Set-3)");
            resetScore();
            dialog.setNegativeButton("Play Again?", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    // User clicked the "Keep editing" button, so dismiss the dialog
                    // and continue editing the pet.
                    if (dialog != null) {
                        resetScore();
                        dialog.dismiss();
                    }
                }
            });
            dialog.setPositiveButton("Exit", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    // User clicked the "Keep editing" button, so dismiss the dialog
                    // and continue editing the pet.
                    if (dialog != null) {
                        finish();

                    }
                }
            });
            dialog.setNeutralButton("Save and Exit", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    addItems();
                    finish();
                }
            });
            dialog.show();

        }
    }
    public void checkGameWinner() {
        if (scoreA > 29) {
            updateTable();
            gameA += 1;
            winnerMessage();
        } else if (scoreA > 20 && scoreA - scoreB > 1) {
            updateTable();
            gameA += 1;
            winnerMessage();
        }
        if (scoreB > 29) {
            updateTable();
            gameB += 1;
            winnerMessage();
        } else if (scoreB > 20 && scoreB - scoreA > 1) {
            updateTable();
            gameB += 1;
            winnerMessage();
        }
        displayScore();
    }
    public void resetScore() {
            scoreA = 0;
            scoreB = 0;
            gameA = 0;
            gameB = 0;
            displayScore();
            gameThreeTeamA.setText(String.valueOf(scoreA));
            gameThreeTeamB.setText(String.valueOf(scoreB));
            gameTwoTeamA.setText(String.valueOf(scoreA));
            gameTwoTeamB.setText(String.valueOf(scoreB));
            gameOneTeamA.setText(String.valueOf(scoreA));
            gameOneTeamB.setText(String.valueOf(scoreB));

    }
    public void addItems(){
        String title = "Badminton";
        String outcome = result;
        String scoreOne = "";
        String scoreTwo = "[Team A] : " + SetOneA + "-" +SetOneB + " : [Team B]";
        String scoreThree ="[Team A] : " + SetTwoA + "-" +SetTwoB + " : [Team B]";
        String scoreFour = "[Team A] : " + SetThreeA + "-" +SetThreeB + " : [Team B]";
        String scoreFive = "";
        Result result = new Result(title,outcome,scoreOne,scoreTwo,scoreThree,scoreFour,scoreFive);
        resultViewModel.insert(result);
    }
}




