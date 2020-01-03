package com.example.anmol.courtcounter.TableTennis;

import android.app.AlertDialog;
import android.content.DialogInterface;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.anmol.courtcounter.R;
import com.example.anmol.courtcounter.SaveResults.Result;
import com.example.anmol.courtcounter.SaveResults.ResultViewModel;

public class TableTennisAcitivity extends AppCompatActivity {

    int scoreA = 0;
    int scoreB = 0;
    int gameA = 0;
    int gameB = 0;
    int resetCounter = 0;
    String winner="";
    TextView teamAHeading;
    TextView teamBHeading;
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
    Button resetButton;
    String SetOneA;
    String SetOneB;
    String SetTwoA;
    String SetTwoB;
    String SetThreeA;
    String SetThreeB;
    String SetFourA;
    String SetFourB;
    String SetFiveA;
    String SetFiveB;
    String result;
    ResultViewModel resultViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_tennis_acitivity);

        resultViewModel = ViewModelProviders.of(this).get(ResultViewModel.class);

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
        teamAHeading = findViewById(R.id.headA);
        teamBHeading = findViewById(R.id.headB);
      resetButton = findViewById(R.id.Reset_Button);
       resetButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               resetScore();
            }
        });

        teamAHeading.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                androidx.appcompat.app.AlertDialog.Builder alertBuilder = new androidx.appcompat.app.AlertDialog.Builder( TableTennisAcitivity.this );
                alertBuilder.setTitle( "Edit Team Name" );

                final EditText input = new EditText( TableTennisAcitivity.this );
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
                androidx.appcompat.app.AlertDialog.Builder alertBuilder = new androidx.appcompat.app.AlertDialog.Builder( TableTennisAcitivity.this );
                alertBuilder.setTitle( "Edit Team Name" );

                final EditText input = new EditText( TableTennisAcitivity.this );
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

    public void resetScore() {
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
               resetCounter = 0;

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


    public void WinnerAlert(){

        final android.app.AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Winner : " + winner);
        result = "Winner :" + winner;
        SetOneA = gameOneTeamA.getText().toString();
        SetOneB = gameOneTeamB.getText().toString();
        SetTwoA = gameTwoTeamA.getText().toString();
        SetTwoB = gameTwoTeamB.getText().toString();
        SetThreeA = gameThreeTeamA.getText().toString();
        SetThreeB =gameThreeTeamB.getText().toString();
        SetFourA = gameFourTeamA.getText().toString();
        SetFourB = gameFourTeamB.getText().toString();
        SetFiveA = gameFiveTeamA.getText().toString();
        SetFiveB = gameFiveTeamB.getText().toString();

        builder.setMessage("Final Scoreline : \n"
                +"\n["+teamAHeading.getText().toString() +"] " + gameOneTeamA.getText().toString() +" - "+gameOneTeamB.getText().toString()+" ["+teamBHeading.getText().toString()+"]"+"\t (Set-1)"
                +"\n["+teamAHeading.getText().toString() +"] " + gameTwoTeamA.getText().toString() +" - "+gameTwoTeamB.getText().toString()+" ["+teamBHeading.getText().toString()+"]"+"\t (Set-2)"
                +"\n["+teamAHeading.getText().toString() +"] " + gameThreeTeamA.getText().toString() +" - "+gameThreeTeamB.getText().toString()+" ["+teamBHeading.getText().toString()+"]"+"\t (Set-3)"
                +"\n["+teamAHeading.getText().toString() +"] " + gameFourTeamA.getText().toString() +" - "+gameFourTeamB.getText().toString()+" ["+teamBHeading.getText().toString()+"]"+"\t (Set-4)"
                +"\n["+teamAHeading.getText().toString() +"] " + gameFiveTeamA.getText().toString() +" - "+gameFiveTeamA.getText().toString()+" ["+teamBHeading.getText().toString()+"]"+"\t (Set-5)");
        builder.setPositiveButton("New Game?", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if(dialogInterface != null){
                resetScore();
            }}
        });
        builder.setNegativeButton("Exit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
              if(dialogInterface != null){  finish();
            }}
        });
        builder.setNeutralButton("Save and Exit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                addItems();
                finish();
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }

    public void winnerMessage() {

        if (gameA > 2) {
            winner = teamAHeading.getText().toString();
            WinnerAlert();

        }
        if (gameB > 2) {
            winner = teamBHeading.getText().toString();
            WinnerAlert();

        }


    }

    public void addItems(){
        String title = "Table Tennis";
        String outcome = result;
        String scoreOne = teamAHeading.getText().toString() +": " + SetOneA + "-" +SetOneB + " :" +teamBHeading.getText().toString();
        String scoreTwo = teamAHeading.getText().toString() +": " + SetTwoA + "-" +SetTwoB + " :" +teamBHeading.getText().toString();
        String scoreFour =teamAHeading.getText().toString() +": " + SetFourA + "-" +SetFourB + " :" +teamBHeading.getText().toString();
        String scoreThree = teamAHeading.getText().toString() +": " + SetThreeA + "-" +SetThreeA + " :" +teamBHeading.getText().toString();
        String scoreFive = teamAHeading.getText().toString() +": " + SetFiveA + "-" +SetFiveB + " :" +teamBHeading.getText().toString();
        Result result = new Result(title,outcome,scoreOne,scoreTwo,scoreThree,scoreFour,scoreFive);
        resultViewModel.insert(result);
    }

}
