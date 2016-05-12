package com.example.jakubkalinowski.sharerydeapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Roya on 5/2/2016.
 */
public class PassengerActivity extends AppCompatActivity {

    private String name;
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<PassengerActivity> getPassengersList() {
        return passengersList;
    }

    public void setPassengersList(List<PassengerActivity> passengersList) {
        this.passengersList = passengersList;
    }

    private List<PassengerActivity> passengersList = new ArrayList<>();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver);


        final TextView passenger = (TextView) findViewById(R.id.tvPassenger);
    }

    public PassengerActivity(String name, String address){
        this.name = name;
        this.address = address;
        passengersList.add(this);
    }
}
