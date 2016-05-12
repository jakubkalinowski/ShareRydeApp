package com.example.jakubkalinowski.sharerydeapp;

/**
 * Created by Roya on 5/2/2016.
 */

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class DriverActivity extends AppCompatActivity {
    private String name;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public List<DriverActivity> getDriversList() {
        return driversList;
    }

    public void setDriversList(List<DriverActivity> driversList) {
        this.driversList = driversList;
    }

    private String address;
    private String vehicle;
    private int numberOfSeats;
    private List<DriverActivity> driversList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver);


    }

    public DriverActivity (String name, String vehicle, int seats, String address ){
        this.name = name;
        this.address = address;
        this.vehicle = vehicle;
        numberOfSeats = seats;
        driversList.add(this);
    }

}
