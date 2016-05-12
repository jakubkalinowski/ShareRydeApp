package com.example.jakubkalinowski.sharerydeapp;

/**
 * Created by Roya on 5/2/2016.
 */

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DriverActivity extends AppCompatActivity {
    private String name;
    private String address;
    private String vehicle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver);


    }

    public DriverActivity (String name, String vehicle, String address ){
        this.name = name;
        this.address = address;
        this.vehicle = vehicle;
    }

}
