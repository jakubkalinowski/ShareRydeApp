package com.example.jakubkalinowski.sharerydeapp;

public class User {

//    Firebase ref = new Firebase("https://shareryde.firebaseio.com/"); 
//    Firebase userRef = ref.child("users"); 
//    AuthData authData;

    private String fullName;
    private String emailAddress;
    private String password;
    private String address;
    private String vehicle;
    private String seatsAmount;
    private String status;
    private int wallet;

    public User(){}

    public User(String fullName, String emailAddress, String password,
                String address, String vehicle, String seatsAmount, String status, int walletInput){
        this.fullName = fullName;
        this.emailAddress = emailAddress;
        this.password = password;
        this.address = address;
        this.vehicle = vehicle;
        this.seatsAmount = seatsAmount;
        this.status = status;
        this.wallet = walletInput;
    }

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
//        Query queryRef = ref.orderByChild("emailAddress");
//
//        authData = ref.getAuth();
//
//        queryRef.addChildEventListener(new ChildEventListener() {
//            @Override
//            public void onChildAdded(DataSnapshot dataSnapshot, String previousChild) {
//                System.out.println(dataSnapshot.getValue());
//                Map<String,Object> value = (Map<String, Object>) dataSnapshot.getValue();
//
//                emailAddress = String.valueOf(value.get("emailAddress"));
//
//                System.out.println("Email is: " + value.get("emailAddress"));//testing
//
//            }
//
//            @Override
//            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
//
//            }
//
//            @Override
//            public void onChildRemoved(DataSnapshot dataSnapshot) {
//
//            }
//
//            @Override
//            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
//
//            }
//
//            @Override
//            public void onCancelled(FirebaseError firebaseError) {
//
//            }



//
//        });

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

    public int getWallet() {
        return wallet;
    }

    public void setWallet(int wallet) {
        this.wallet = wallet;
    }
}