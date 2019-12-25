package com.example.anmol.courtcounter;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class Splash extends AppCompatActivity {

    ImageView imageView;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_splash );

        imageView = findViewById( R.id.imageView );


        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                startActivity( new Intent( Splash.this, MainActivity.class ) );
                finish();
            }
        };

        imageView.animate()
                .rotationBy( 180 )
                .setDuration( 1000 ).withEndAction( runnable );

    }
}
