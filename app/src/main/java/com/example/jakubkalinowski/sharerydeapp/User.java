package com.example.jakubkalinowski.sharerydeapp;

public class User {
    private String fullName;
    private String emailAddress;
    private String password;
    private String address;
    private String vehicle;
    private String seatsAmount;
    private String status;
//    private HashMap<String, String> arrivals;
//    private HashMap<String, String> departures;

//    private ToggleButton status;

    public User(){}

    public User(String fullName, String emailAddress, String password, String address,
                String vehicle, String seatsAmount, String status){
//                HashMap<String, String> arrivals, HashMap<String, String> departures){
        this.fullName = fullName;
        this.emailAddress = emailAddress;
        this.password = password;
        this.address = address;
        this.vehicle = vehicle;
        this.seatsAmount = seatsAmount;
        this.status = status;
//        this.arrivals = arrivals;
//        this.departures = departures;
    }

//    public HashMap<String, String> getArrivals() {
//        return arrivals;
//    }
//
//    public void setArrivals(HashMap<String, String> arrivals) {
//        this.arrivals = arrivals;
//    }
//
//    public HashMap<String, String> getDepartures() {
//        return departures;
//    }
//
//    public void setDepartures(HashMap<String, String> departures) {
//        this.departures = departures;
//    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public String getSeatsAmount() {
        return seatsAmount;
    }

    public void setSeatsAmount(String seatsAmount) {
        this.seatsAmount = seatsAmount;
    }
}