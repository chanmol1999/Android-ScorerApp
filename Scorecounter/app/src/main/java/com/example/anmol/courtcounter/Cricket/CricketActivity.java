package com.example.anmol.courtcounter.Cricket;

import android.content.DialogInterface;
import android.content.Intent;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.example.anmol.courtcounter.MainActivity;
import com.example.anmol.courtcounter.R;
import com.example.anmol.courtcounter.SaveResults.Result;
import com.example.anmol.courtcounter.SaveResults.ResultViewModel;

public class CricketActivity extends AppCompatActivity {

    boolean isWideA = false;
    boolean isNoBallA = false;
    boolean isWideB = false;
    boolean isNoBallB = false;
    boolean teamABat = false;
    boolean teamBBat = false;
    boolean wickFellA = false;
    boolean wickFellB = false;
    int MaxOvers = 0;
    int wicketA = 0;
    int wicketB = 0;
    int ScoreBallA = 0;
    int ScoreBallB = 0;
    boolean wickA = false;
    boolean wickB = false;
    int scoreTeamA = 0;
    int ballTeamA = 1;
    int overTeamA = 0;
    int scoreTeamB = 0;
    int ballTeamB = 1;
    int overTeamB = 0;
    boolean isSuperOver = false;
    String team;
    String format;
    Button resButton;
    String result;
    ResultViewModel resultViewModel;
    TextView teamAHeading;
    TextView teamBHeading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_cricket );

        teamAHeading = findViewById(R.id.headA);
        teamBHeading = findViewById(R.id.headB);
        resultViewModel = ViewModelProviders.of(this).get(ResultViewModel.class);
        team = getIntent().getStringExtra( "BAT_FIRST" );
        format = getIntent().getStringExtra( "MATCH_TYPE" );
        resButton = findViewById( R.id.resButton );
        resButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reset();
            }
        } );
        if (team.equals( "A" )) {
            teamABat = true;
            teamBBat = false;
        } else {
            teamABat = false;
            teamBBat = true;
        }

        if (format.equals( "T20" )) {
            MaxOvers = 20;
        } else {
            MaxOvers = 50;
        }

        scoreTeamA = 0;
        scoreTeamB = 0;
        (findViewById( R.id.team_a_ball_1 )).setBackgroundResource( R.color.colorSuccess );
        (findViewById( R.id.team_b_ball_1 )).setBackgroundResource( R.color.colorSuccess );

        teamAHeading.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                androidx.appcompat.app.AlertDialog.Builder alertBuilder = new androidx.appcompat.app.AlertDialog.Builder( CricketActivity.this );
                alertBuilder.setTitle( "Edit Team Name" );

                final EditText input = new EditText( CricketActivity.this );
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
                androidx.appcompat.app.AlertDialog.Builder alertBuilder = new androidx.appcompat.app.AlertDialog.Builder( CricketActivity.this );
                alertBuilder.setTitle( "Edit Team Name" );

                final EditText input = new EditText( CricketActivity.this );
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

    public void addRunsTeamA(View view) {
        if (teamABat == false) {
            invalid();
            return;
        }
        TextView runField = findViewById( R.id.team_a_runs );
        int score = Integer.parseInt( runField.getText().toString() );
        if (isNoBallA == true || isWideA == true)
            score++;
        scoreTeamA += score;
        ScoreBallA += score;
        runField.setText( "0" );
        displayOverScoreTeamA();
        displayScoreTeamA( scoreTeamA );
    }

    public void incrementRunsTeamA(View view) {
        if (teamABat == false) {
            invalid();
            return;
        }
        TextView runField = findViewById( R.id.team_a_runs );
        int score = Integer.parseInt( runField.getText().toString() );
        score += 1;
        runField.setText( "" + score );
    }

    public void decrementRunsTeamA(View view) {
        if (teamABat == false) {
            invalid();
            return;
        }
        TextView runField = findViewById( R.id.team_a_runs );
        int score = Integer.parseInt( runField.getText().toString() );
        if (score > 0) score -= 1;
        runField.setText( "" + score );
    }

    public void addFourTeamA(View view) {
        if (teamABat == false) {
            invalid();
            return;
        }
        scoreTeamA += 4;
        ScoreBallA += 4;
        displayOverScoreTeamA();
        displayScoreTeamA( scoreTeamA );
    }

    public void addSixTeamA(View view) {
        if (teamABat == false) {
            invalid();
            return;
        }
        scoreTeamA += 6;
        ScoreBallA += 6;
        displayOverScoreTeamA();
        displayScoreTeamA( scoreTeamA );
    }

    public void outTeamA(View view) {
        if (teamABat == false) {
            invalid();
            return;
        }
        wickA = true;
        wickFellA = true;
    }

    private void displayOverScoreTeamA() {
        String displayScore = "";
        TextView currentView = null;
        TextView swap = null;
        displayScore = "" + ScoreBallA;
        switch (ballTeamA) {
            case 1:
                currentView = findViewById( R.id.team_a_ball_1 );
                if (isWideA == false && isNoBallA == false)
                    findViewById( R.id.team_a_ball_2 ).setBackgroundResource( R.color.colorSuccess );
                break;
            case 2:
                currentView = findViewById( R.id.team_a_ball_2 );
                if (isWideA == false && isNoBallA == false)
                    findViewById( R.id.team_a_ball_3 ).setBackgroundResource( R.color.colorSuccess );
                break;
            case 3:
                currentView = findViewById( R.id.team_a_ball_3 );
                if (isWideA == false && isNoBallA == false)
                    findViewById( R.id.team_a_ball_4 ).setBackgroundResource( R.color.colorSuccess );
                break;
            case 4:
                currentView = findViewById( R.id.team_a_ball_4 );
                if (isWideA == false && isNoBallA == false)
                    findViewById( R.id.team_a_ball_5 ).setBackgroundResource( R.color.colorSuccess );
                break;
            case 5:
                currentView = findViewById( R.id.team_a_ball_5 );
                if (isWideA == false && isNoBallA == false)
                    findViewById( R.id.team_a_ball_6 ).setBackgroundResource( R.color.colorSuccess );
                break;
            case 6:
                currentView = findViewById( R.id.team_a_ball_6 );
                if (isWideA == false && isNoBallA == false)
                    findViewById( R.id.team_a_ball_1 ).setBackgroundResource( R.color.colorSuccess );
                break;
            default:
                currentView = findViewById( R.id.team_a_ball_1 );
                swap = findViewById( R.id.team_a_ball_2 );
                swap.setText( "0" );
                swap.setBackgroundResource( R.color.colorSuccess );
                swap = findViewById( R.id.team_a_ball_3 );
                swap.setText( "0" );
                swap.setBackgroundResource( R.color.transparent );
                swap = findViewById( R.id.team_a_ball_4 );
                swap.setText( "0" );
                swap.setBackgroundResource( R.color.transparent );
                swap = findViewById( R.id.team_a_ball_5 );
                swap.setText( "0" );
                swap.setBackgroundResource( R.color.transparent );
                swap = findViewById( R.id.team_a_ball_6 );
                swap.setText( "0" );
                swap.setBackgroundResource( R.color.transparent );
                ballTeamA = 1;
        }
        currentView.setText( displayScore );
        if (wickA == true) {
            wicketA++;
            currentView.setBackgroundResource( R.color.colorDanger );
            swap = findViewById( R.id.team_a_wickets );
            swap.setText( String.format( "%d", Integer.parseInt( swap.getText().toString() ) + 1 ) );
        } else {
            if (isWideA == false && isNoBallA == false && wickFellA == false)
                currentView.setBackgroundResource( R.color.transparent );
        }
        if (isWideA == false && isNoBallA == false) {
            swap = findViewById( R.id.team_a_over );
            if (ballTeamA != 6)
                swap.setText( String.format( "%d.%d", overTeamA, ballTeamA ) );
            else {
                overTeamA++;
                swap.setText( String.format( "%d", overTeamA ) );
            }
            ballTeamA++;
            ScoreBallA = 0;
            wickFellA = false;
        }
        isWideA = false;
        isNoBallA = false;
        wickA = false;
        if ((overTeamA == MaxOvers || wicketA == 10) && (overTeamB == 0 && wicketB == 0)) {
            teamABat = false;
            teamBBat = true;
            AlertDialog.Builder builder = new AlertDialog.Builder( this );
            builder.setMessage( "Team B need " + (scoreTeamA + 1) + " runs to win!" );
            builder.setPositiveButton( "Continue", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    if (dialog != null) {
                        dialog.dismiss();
                    }
                }
            } );
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        }
        if (team.equals( "B" ) && scoreTeamA > scoreTeamB) {
            result();
        }
        if ((overTeamA == MaxOvers || wicketA == 10) && (overTeamB == MaxOvers || wicketB == 10)) {
            result();
        }
    }

    private void displayScoreTeamA(int score) {
        TextView scoreField = findViewById( R.id.team_a_score );
        scoreField.setText( "" + score );
    }

    public void addRunsTeamB(View view) {
        if (teamBBat == false) {
            invalid();
            return;
        }
        TextView runField = findViewById( R.id.team_b_runs );
        int score = Integer.parseInt( runField.getText().toString() );
        if (isWideB == true || isNoBallB == true) {
            score++;
        }
        scoreTeamB += score;
        ScoreBallB += score;
        runField.setText( "0" );
        displayOverScoreTeamB();
        displayScoreTeamB( scoreTeamB );
    }

    public void incrementRunsTeamB(View view) {
        if (teamBBat == false) {
            invalid();
            return;
        }
        TextView runField = findViewById( R.id.team_b_runs );
        int score = Integer.parseInt( runField.getText().toString() );
        score += 1;
        runField.setText( "" + score );
    }

    public void decrementRunsTeamB(View view) {
        if (teamBBat == false) {
            invalid();
            return;
        }
        TextView runField = findViewById( R.id.team_b_runs );
        int score = Integer.parseInt( runField.getText().toString() );
        if (score > 0) score -= 1;
        runField.setText( "" + score );
    }

    public void addFourTeamB(View view) {
        if (teamBBat == false) {
            invalid();
            return;
        }
        scoreTeamB += 4;
        ScoreBallB += 4;
        displayOverScoreTeamB();
        displayScoreTeamB( scoreTeamB );
    }

    public void addSixTeamB(View view) {
        if (teamBBat == false) {
            invalid();
            return;
        }
        scoreTeamB += 6;
        ScoreBallB += 6;
        displayOverScoreTeamB();
        displayScoreTeamB( scoreTeamB );
    }

    public void outTeamB(View view) {
        if (teamBBat == false) {
            invalid();
            return;
        }
        wickB = true;
        wickFellB = true;
    }

    private void displayOverScoreTeamB() {
        String displayScore;
        TextView currentView = null;
        TextView swap = null;
        displayScore = "" + ScoreBallB;
        switch (ballTeamB) {
            case 1:
                currentView = findViewById( R.id.team_b_ball_1 );
                if (isNoBallB == false && isWideB == false)
                    findViewById( R.id.team_b_ball_2 ).setBackgroundResource( R.color.colorSuccess );
                break;
            case 2:
                currentView = findViewById( R.id.team_b_ball_2 );
                if (isNoBallB == false && isWideB == false)
                    findViewById( R.id.team_b_ball_3 ).setBackgroundResource( R.color.colorSuccess );
                break;
            case 3:
                currentView = findViewById( R.id.team_b_ball_3 );
                if (isNoBallB == false && isWideB == false)
                    findViewById( R.id.team_b_ball_4 ).setBackgroundResource( R.color.colorSuccess );
                break;
            case 4:
                currentView = findViewById( R.id.team_b_ball_4 );
                if (isNoBallB == false && isWideB == false)
                    findViewById( R.id.team_b_ball_5 ).setBackgroundResource( R.color.colorSuccess );
                break;
            case 5:
                currentView = findViewById( R.id.team_b_ball_5 );
                if (isNoBallB == false && isWideB == false)
                    findViewById( R.id.team_b_ball_6 ).setBackgroundResource( R.color.colorSuccess );
                break;
            case 6:
                currentView = findViewById( R.id.team_b_ball_6 );
                break;
            default:
                currentView = findViewById( R.id.team_b_ball_1 );
                swap = findViewById( R.id.team_b_ball_2 );
                swap.setText( "0" );
                swap.setBackgroundResource( R.color.colorSuccess );
                swap = findViewById( R.id.team_b_ball_3 );
                swap.setText( "0" );
                swap.setBackgroundResource( R.color.transparent );
                swap = findViewById( R.id.team_b_ball_4 );
                swap.setText( "0" );
                swap.setBackgroundResource( R.color.transparent );
                swap = findViewById( R.id.team_b_ball_5 );
                swap.setText( "0" );
                swap.setBackgroundResource( R.color.transparent );
                swap = findViewById( R.id.team_b_ball_6 );
                swap.setText( "0" );
                swap.setBackgroundResource( R.color.transparent );
                ballTeamB = 1;
        }
        currentView.setText( displayScore );
        if (wickB == true) {
            wicketB++;
            currentView.setBackgroundResource( R.color.colorDanger );
            swap = findViewById( R.id.team_b_wickets );
            swap.setText( String.format( "%d", Integer.parseInt( swap.getText().toString() ) + 1 ) );
        } else {
            if (isNoBallB == false && isWideB == false && wickFellB == false)
                currentView.setBackgroundResource( R.color.transparent );
        }
        if (isNoBallB == false && isWideB == false) {
            swap = findViewById( R.id.team_b_over );
            if (ballTeamB != 6)
                swap.setText( String.format( "%d.%d", overTeamB, ballTeamB ) );
            else {
                overTeamB++;
                swap.setText( String.format( "%d", overTeamB ) );
            }
            ballTeamB++;
            ScoreBallB = 0;
            wickFellB = false;
        }
        wickB = false;
        isWideB = false;
        isNoBallB = false;
        if ((overTeamB == MaxOvers || wicketB == 10) && (overTeamA == 0 && wicketA == 0)) {
            teamBBat = false;
            teamABat = true;
            AlertDialog.Builder builder = new AlertDialog.Builder( this );
            builder.setMessage( "Team A need " + (scoreTeamB + 1) + " runs to win!" );
            builder.setPositiveButton( "Continue", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    if (dialog != null) {
                        dialog.dismiss();
                    }
                }
            } );
            AlertDialog alertDialog = builder.create();
            alertDialog.show();

        }
        if (team.equals( "A" ) && scoreTeamB > scoreTeamA) {
            result();
        }
        if ((overTeamA == MaxOvers || wicketA == 10) && (overTeamB == MaxOvers || wicketB == 10)) {
            result();
        }
    }

    private void displayScoreTeamB(int score) {
        TextView scoreField = findViewById( R.id.team_b_score );
        scoreField.setText( "" + score );
    }

    public void wideA(View view) {
        isWideA = true;
    }

    public void noBallA(View view) {
        isNoBallA = true;
    }

    public void wideB(View view) {
        isWideB = true;
    }

    public void noBallB(View view) {
        isNoBallB = true;
    }

    public void invalid() {
        if (teamABat) {
            Toast.makeText( (getApplicationContext()), "Team A's batting!", (Toast.LENGTH_SHORT) ).show();
        } else if (teamBBat) {
            Toast.makeText( (getApplicationContext()), "Team B's batting!", (Toast.LENGTH_SHORT) ).show();
        } else {
            Toast.makeText( (getApplicationContext()), "Match Over!", (Toast.LENGTH_SHORT) ).show();
        }
    }

    public void result() {
        ((TextView) findViewById( R.id.resButton )).setText( "EXIT" );
        teamABat = false;
        teamBBat = false;
        AlertDialog.Builder builder = new AlertDialog.Builder( this );
        if (scoreTeamA > scoreTeamB) {
            builder.setTitle( "Winner : "+ teamAHeading.getText().toString() );
            result = "Winner : "+ teamAHeading.getText().toString();
            builder.setMessage( "Final Scoreline :" + "\n"+teamAHeading.getText().toString() +": " + scoreTeamA + "/" + wicketA + "\n"+ teamBHeading.getText().toString() + ": " + scoreTeamB + "/" + wicketB );
        } else if (scoreTeamA < scoreTeamB) {
            builder.setTitle( "Winner : "+ teamBHeading.getText().toString() );
            result = "Winner : "+ teamBHeading.getText().toString();
            builder.setMessage( "Final Scoreline :" + "\n"+teamAHeading.getText().toString() +": " + scoreTeamA + "/" + wicketA + "\n"+ teamBHeading.getText().toString() + ": " + scoreTeamB + "/" + wicketB );
        } else if (scoreTeamA == scoreTeamB && MaxOvers == 20) {
            isSuperOver = true;
            superOver();
            builder.setTitle( "Scores Tied, Super Over!" );
            builder.setMessage( "Final Scoreline :" + "\n"+teamAHeading.getText().toString() +": " + scoreTeamA + "/" + wicketA + "\n"+ teamBHeading.getText().toString() + ": " + scoreTeamB + "/" + wicketB );
        } else {
            builder.setTitle( "Match Tied" );
            result = "Match Tied";
            builder.setMessage( "Final Scoreline :" + "\n"+teamAHeading.getText().toString() +": " + scoreTeamA + "/" + wicketA + "\n"+ teamBHeading.getText().toString() + ": " + scoreTeamB + "/" + wicketB );
        }
        if (!(scoreTeamA == scoreTeamB && isSuperOver)) {
            builder.setNegativeButton( "ANOTHER GAME", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    if (dialog != null) {
                        Intent newGame = new Intent( CricketActivity.this, SelectFormat.class );
                        startActivity( newGame );
                        dialog.dismiss();
                    }
                }
            } );

            builder.setPositiveButton( "EXIT", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    if (dialog != null) {
                        Intent exit = new Intent( CricketActivity.this, MainActivity.class );
                        startActivity( exit );
                    }
                }
            } );
            builder.setNeutralButton("Save and Exit", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    addItems();
                    Intent exit = new Intent( CricketActivity.this, MainActivity.class );
                    startActivity( exit );
                }
            });
        } else {
            builder.setPositiveButton( "Continue", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    if (dialog != null) {
                        dialog.dismiss();
                    }
                }
            });
        }
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
        isSuperOver = false;
    }

    public void superOver() {
        if (team.equals( "A" )) {
            teamABat = true;
            teamBBat = false;
        } else {
            teamABat = false;
            teamBBat = true;
        }
        reset();
        MaxOvers = 1;
    }

    public void reset() {
        if (!teamABat && !teamBBat && isSuperOver) {
            Intent exit = new Intent( CricketActivity.this, MainActivity.class );
            startActivity( exit );
        }
        // Reset Scores
        ((TextView) findViewById( R.id.team_a_score )).setText( "0" );
        ((TextView) findViewById( R.id.team_b_score )).setText( "0" );
        scoreTeamA = 0;
        scoreTeamB = 0;

        // Reset Over
        ((TextView) findViewById( R.id.team_a_over )).setText( "0" );
        ((TextView) findViewById( R.id.team_b_over )).setText( "0" );
        overTeamA = 0;
        overTeamB = 0;
        ballTeamA = 1;
        ballTeamB = 1;

        isWideA = false;
        isWideB = false;
        isNoBallA = false;
        isNoBallB = false;
        wicketA = 0;
        wicketB = 0;
        ScoreBallA = 0;
        ScoreBallB = 0;

        //Reset Wickets
        ((TextView) findViewById( R.id.team_a_wickets )).setText( "0" );
        ((TextView) findViewById( R.id.team_b_wickets )).setText( "0" );

        // Reset Team A over scores
        ((TextView) findViewById( R.id.team_a_ball_1 )).setText( "0" );
        ((TextView) findViewById( R.id.team_a_ball_2 )).setText( "0" );
        ((TextView) findViewById( R.id.team_a_ball_3 )).setText( "0" );
        ((TextView) findViewById( R.id.team_a_ball_4 )).setText( "0" );
        ((TextView) findViewById( R.id.team_a_ball_5 )).setText( "0" );
        ((TextView) findViewById( R.id.team_a_ball_6 )).setText( "0" );
        findViewById( R.id.team_a_ball_1 ).setBackgroundResource( R.color.colorSuccess );
        findViewById( R.id.team_a_ball_2 ).setBackgroundResource( R.color.transparent );
        findViewById( R.id.team_a_ball_3 ).setBackgroundResource( R.color.transparent );
        findViewById( R.id.team_a_ball_4 ).setBackgroundResource( R.color.transparent );
        findViewById( R.id.team_a_ball_5 ).setBackgroundResource( R.color.transparent );
        findViewById( R.id.team_a_ball_6 ).setBackgroundResource( R.color.transparent );

        // Reset Team B over scores
        ((TextView) findViewById( R.id.team_b_ball_1 )).setText( "0" );
        ((TextView) findViewById( R.id.team_b_ball_2 )).setText( "0" );
        ((TextView) findViewById( R.id.team_b_ball_3 )).setText( "0" );
        ((TextView) findViewById( R.id.team_b_ball_4 )).setText( "0" );
        ((TextView) findViewById( R.id.team_b_ball_5 )).setText( "0" );
        ((TextView) findViewById( R.id.team_b_ball_6 )).setText( "0" );
        findViewById( R.id.team_b_ball_1 ).setBackgroundResource( R.color.colorSuccess );
        findViewById( R.id.team_b_ball_2 ).setBackgroundResource( R.color.transparent );
        findViewById( R.id.team_b_ball_3 ).setBackgroundResource( R.color.transparent );
        findViewById( R.id.team_b_ball_4 ).setBackgroundResource( R.color.transparent );
        findViewById( R.id.team_b_ball_5 ).setBackgroundResource( R.color.transparent );
        findViewById( R.id.team_b_ball_6 ).setBackgroundResource( R.color.transparent );
    }

    public void addItems(){
        String title = "Cricket";
        String outcome = result;
        String scoreTwo = teamAHeading.getText().toString() + ": " + scoreTeamA + "/" +wicketA ;
        String scoreThree = teamBHeading.getText().toString() + ": " + scoreTeamB + "/" +wicketB ;
        String scoreFour ="";
        String scoreOne = "";
        String scoreFive = "";
        Result result = new Result(title,outcome,scoreOne,scoreTwo,scoreThree,scoreFour,scoreFive);
        resultViewModel.insert(result);
    }
}


