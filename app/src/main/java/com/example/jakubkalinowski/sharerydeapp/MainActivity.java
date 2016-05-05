package com.example.jakubkalinowski.sharerydeapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.firebase.client.Firebase;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    //Firebase Reference
    Firebase ref = new Firebase("https://shareryde.firebaseio.com/");

    //variables for all the components of the activity
    private ToggleButton mStatusButton;
    private Button mRequestButton;
    private Button mPaymentButton;
    private Button mProfileButton;
    private Button mScheduleButton;
    private Button mSettingsButton;

    //variables for extracting values from components
    private ToggleButton currentStatus;

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
    }

    @Override
    protected void onStart() {
        super.onStart();
        Firebase.setAndroidContext(this);

        //initializing activity components
        mStatusButton = (ToggleButton) findViewById(R.id.statusButton);
        mRequestButton = (Button) findViewById(R.id.requestButton);
        mPaymentButton = (Button) findViewById(R.id.paymentButton);
        mProfileButton = (Button) findViewById(R.id.profileButton);
        mScheduleButton = (Button) findViewById(R.id.scheduleButton);
        mSettingsButton = (Button) findViewById(R.id.settingsButton);

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
         * Action for 'mScheduleButton'
         * User enters Edit Schedule screen
         */
        mScheduleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startSignUp = new Intent(MainActivity.this, MemberScheduleActivity.class);
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
        mStatusButton.setOnCheckedChangeListener(this);
    }

    /**
     * Action for changing status
     * @param buttonView
     * @param isChecked
     */
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
                    Firebase userRef = ref.child("users");
                    userRef.child("status").setValue("driver");

        } else {
//                    Firebase userRef = ref.child("users");
//                    userRef.child("status").setValue("passenger");
            ref.child("users").child("status").setValue("driver");

        }
    }


}

