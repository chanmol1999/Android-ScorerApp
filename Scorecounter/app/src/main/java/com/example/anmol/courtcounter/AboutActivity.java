package com.example.anmol.courtcounter;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Objects;


public class AboutActivity extends AppCompatActivity {
    TextView about_details;
    ImageView github_launch_icon;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_about );

        Objects.requireNonNull( getSupportActionBar() ).setTitle( "About" );
        about_details = findViewById( R.id.about_details );
        github_launch_icon = findViewById( R.id.github_launch_icon );
        github_launch_icon.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse( Urls.GITHUB_REPO_URL );
                Intent intent = new Intent( Intent.ACTION_VIEW, uri );
                startActivity( intent );
            }
        } );
    }
}
