package com.example.anmol.courtcounter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.anmol.courtcounter.Badminton.BadmintonActivity;
import com.example.anmol.courtcounter.Basketball.BasketballActivity;
import com.example.anmol.courtcounter.Cricket.CricketActivity;
import com.example.anmol.courtcounter.TableTennis.tableTennisAcitivity;
import com.example.anmol.courtcounter.Volleyball.VolleyballActivity;

public class MainActivity extends AppCompatActivity {

    Button basketball;
    Button volleyball;
    Button badminton;
    Button cricket;
    Button tableTennis;
    Button football;
    Button kabaddi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        basketball = findViewById(R.id.button_basketball);
        volleyball = findViewById(R.id.button_volleyball);
        badminton =  findViewById(R.id.button_badminton);
        cricket = findViewById(R.id.button_cricket);
        tableTennis =findViewById(R.id.button_tableTennis);
        football = findViewById(R.id.button_football);
        kabaddi = findViewById(R.id.button_kabaddi);


        basketball.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, BasketballActivity.class));
            }
        });

        volleyball.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, VolleyballActivity.class));
            }
        });

        badminton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, BadmintonActivity.class));
            }
        });

        cricket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, CricketActivity.class));
            }
        });

        tableTennis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, tableTennisAcitivity.class));
            }
        });

        football.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, com.example.anmol.courtcounter.Football.footballActivity.class));
            }
        });

        kabaddi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, com.example.anmol.courtcounter.Kabaddi.kabaddiActivity.class));
            }
        });

    }
}
