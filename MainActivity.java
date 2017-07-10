package com.incredibleindia.android.incredibleindia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the explore button on the home screen
        ImageView exploreButton = (ImageView) findViewById(R.id.button_explore);

        // Set a click listener on that button
        exploreButton.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the explore button is clicked on.
            @Override
            public void onClick(View view) {
                Intent indiaIntent = new Intent(MainActivity.this, ExploreIndia.class);
                startActivity(indiaIntent);
            }
        });

    }
}
