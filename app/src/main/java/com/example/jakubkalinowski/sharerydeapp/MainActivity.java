package com.example.jakubkalinowski.sharerydeapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //final EditText etUsername = (EditText) findViewById(R.id.etUsername);

        final TextView welcomeMessage = (TextView) findViewById(R.id.tvWelcomeMSG);

        final Button offerRide = (Button) findViewById(R.id.bOfferRide);
        final Button requestRide = (Button) findViewById(R.id.bRequestRide);


        offerRide.setOnClickListener(new View.OnClickListener() {

            public void onClick (View v){
                Intent offerRideIntent = new Intent(MainActivity.this, MapsActivity.class);
                MainActivity.this.startActivity(offerRideIntent);
            }
        });

        requestRide.setOnClickListener(new View.OnClickListener() {

            public void onClick (View v){
                Intent requestRideIntent = new Intent(MainActivity.this, MapsActivity.class);
                MainActivity.this.startActivity(requestRideIntent);
            }
        });
    }
}
