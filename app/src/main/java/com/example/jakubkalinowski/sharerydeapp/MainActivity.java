package com.example.jakubkalinowski.sharerydeapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.firebase.client.AuthData;
import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

public class MainActivity extends AppCompatActivity  {

    //Firebase Reference
    FindLocation fl = new FindLocation();
    registerActivity ra = new registerActivity();
    Firebase ref = new Firebase("https://shareryde.firebaseio.com/");
    AuthData authData;

    //variables for all the components of the activity
    private Button mStatusButton;
    private Button mRequestButton;
    private Button mPaymentButton;
    private Button mProfileButton;
    private Button mLogoutButton;

    //variables for extracting values from components
    private boolean status = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //final EditText etUsername = (EditText) findViewById(R.id.etUsername);

        final TextView welcomeMessage = (TextView) findViewById(R.id.logoText);

//        final Button offerRide = (Button) findViewById(R.id.bOfferRide);


//        offerRide.setOnClickListener(new View.OnClickListener() {
//
//            public void onClick(View v) {
//                Intent offerRideIntent = new Intent(MainActivity.this, MapsActivity.class);
//                MainActivity.this.startActivity(offerRideIntent);
//            }
//        });

//



    }// end of oncreate

    @Override
    protected void onStart() {
        super.onStart();
        Firebase.setAndroidContext(this);

        //initializing activity components
        mStatusButton = (Button) findViewById(R.id.statusButton);
        mRequestButton = (Button) findViewById(R.id.requestButton);
        mPaymentButton = (Button) findViewById(R.id.paymentButton);
        mProfileButton = (Button) findViewById(R.id.profileButton);
        mLogoutButton = (Button) findViewById(R.id.logoutButton);

        authData = ref.getAuth();

        /**
         * Populate the button with user status fetched from db
         */

       // mStatusButton.setText()
        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

//                System.out.println("Status: " + dataSnapshot.child());
//                System.out.println("Status: " + dataSnapshot.child(authData.getUid().toString() + "/status").getValue(ref.child(authData.getUid().toString()).child("/status"));
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

//        if (temp.equals("passenger")) {
//            mStatusButton.setText("Switch to Driver");
//        }
//        else {
//            mStatusButton.setText("Switch to Driver");
//        }




        /**
         * Action for 'mRequestButton'
         * user requests a ride
         */
        mRequestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startSignUp = new Intent(MainActivity.this, MapsActivity.class);
                startActivity(startSignUp);
            }
        });

        /**
         * Action for 'mPaymentButton
         * User enters Payments Screen
         */
        mPaymentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startSignUp = new Intent(MainActivity.this, PaymentActivity.class);
                startActivity(startSignUp);
            }
        });

        /**
         * Action for 'mStatusCheck'
         * Change user's status - driver or passenger
         * Checked is Driver, not checked is Passenger
         */


        mStatusButton.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Firebase userRef = ref.child("users");

                if (status == true) {
                    mStatusButton.setText("Switch to a Passenger");
                    userRef.child(authData.getUid().toString()).child("status").setValue("driver");

                    status = false;
                } else if(status == false) {
                    mStatusButton.setText("Switch to a Driver");
                    userRef.child(authData.getUid().toString()).child("status").setValue("passenger");

                    status = true;
                }
            }
        });

        /**
         * Action for 'mLogoutButton'
         */
        mLogoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startSignUp = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(startSignUp);
            }
        });
    }


    /**
     * Action for changing status
     * @param buttonView
     * @param isChecked
     */
//    @Override
//    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//        if (isChecked) {
//                    Firebase userRef = ref.child("users");
//                    userRef.child("status").setValue("driver");
//            System.out.println("Driver");
//
//        } else {
////                    Firebase userRef = ref.child("users");
////                    userRef.child("status").setValue("passenger");
//            ref.child("users").child("status").setValue("driver");
//            System.out.println("passenger");
//        }
//    }


}

