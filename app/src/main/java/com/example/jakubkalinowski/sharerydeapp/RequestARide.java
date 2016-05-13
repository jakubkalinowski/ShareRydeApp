package com.example.jakubkalinowski.sharerydeapp;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class RequestARide extends AppCompatActivity {

    ProgressBar progressBar ;
    private Handler handler = new Handler();
    Runnable runnable = null, runnableTimer;
    TextView searching,information;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_aride);

        information = (TextView) findViewById(R.id.informationID);
        searching = (TextView)findViewById(R.id.searchingID);
        progressBar = (ProgressBar) findViewById(R.id.progressID);

        progressBar.setVisibility(View.VISIBLE);

        runnableTimer = new Runnable() {
            @Override
            public void run() {
                progressBar.setVisibility(View.INVISIBLE);
                searching.setVisibility(View.INVISIBLE);
                searchForDrivers();
                information.setText("Driver: Jakub Douchy");
            }
        };
        handler.postDelayed(runnableTimer, 1000*3);

        searchForDrivers();

    }

    private void searchForDrivers() {
        // search for drivers near you
        // this will be done by looking at longitude and latitude of drivers.
        //iterate through the list, find the closest driver to user.


    }
}
