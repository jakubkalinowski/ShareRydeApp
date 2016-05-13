package com.example.jakubkalinowski.sharerydeapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.firebase.client.AuthData;
import com.firebase.client.Firebase;


public class MainActivity extends AppCompatActivity {

    //Firebase Reference
    Firebase ref = new Firebase("https://shareryde.firebaseio.com/");
    AuthData authData;

    //variables for all the components of the activity
    private Button mStatusButton;
    private Button mRequestButton;
    private Button mPaymentButton;
    private Button mProfileButton;
    private Button mLogoutButton;
    private Button mMessagesButton;
    private Button mReviewButton;

    //variables for extracting values from components
    private boolean status = false;
    String userID = ref.getAuth().getUid();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Firebase.setAndroidContext(this);

        final TextView welcomeMessage = (TextView) findViewById(R.id.logoText);

//        GoogleApiClient.Builder mGoogleApiClient = new GoogleApiClient.Builder(this);
//       //  Create an instance of GoogleAPIClient.
//        if (mGoogleApiClient == null) {
//            mGoogleApiClient = new GoogleApiClient.Builder(this)
//                    .addConnectionCallbacks(this)
//                    .addOnConnectionFailedListener(this)
//                    .addApi(LocationServices.API)
//                    .build();
//        }
//
//        requestRide.setOnClickListener(new View.OnClickListener() {
//
//            public void onClick(View v) {
//                Intent requestRideIntent = new Intent(MainActivity.this, MapsActivity.class);
//                MainActivity.this.startActivity(requestRideIntent);
//            }
//        });
    }

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
        mMessagesButton = (Button) findViewById(R.id.messagesButton);
        mReviewButton = (Button) findViewById(R.id.reviewButton);

        authData = ref.getAuth();
        userID = ref.getAuth().getUid();
        Firebase usersRef = ref.child("users");
        /**
         * Populate the button with user status fetched from db
         */

        /**
         * Action for 'mRequestButton'
         * user requests a ride
         */
        mRequestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, MapsActivity.class);
                startActivity(i);
            }
        });


        mStatusButton.setText(usersRef.child(authData.getUid().toString()).child("status").getKey());
//        mStatusButton.setText(userID.);
//         mStatusButton.setText();
//        ref.addChildEventListener(new ChildEventListener() {
//            Query query = ref.orderByChild("user").equalTo("597eee31-b743-4aef-95fd-c5dc0fde4f8c");
//            query.addChildEventListener(new ChildEventListener() {
//            @Override
//            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
////                Map<String, Object> newPost = (Map<String, Object>) dataSnapshot.getValue();
////                System.out.println("Status: " + newPost.get("status"));
//            }
//
//            @Override
//            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
//                Map<String, Object> newPost = (Map<String, Object>) dataSnapshot.getValue();
//                System.out.println("Status: " + newPost.get("status"));
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
//        });

        /**
         * Action for 'mMessagesButton'
         * Allows users to communicate
         */
        mMessagesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, MessagesActivity.class);
                startActivity(i);
            }
        });

        /**
         * Action for 'mPaymentButton'
         * User enters Payments Screen
         */
        mPaymentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, PaymentActivity.class);
                startActivity(i);
            }
        });

        /**
         * Action for 'mReviewButton'
         * Redirects to review screen
         */
        mReviewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ReviewActivity.class);
                startActivity(i);
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
                Intent i = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });
    }

    /**
     * Action for changing status
//     * @param buttonView
//     * @param isChecked
     */
//    @Override
//    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//        if (isChecked) {
//                    Firebase userRef = ref.child("users");
//                    userRef.child("status").setValue("driver");
//
//        } else {
////                    Firebase userRef = ref.child("users");
////                    userRef.child("status").setValue("passenger");
//            ref.child("users").child("status").setValue("driver");
//
//        }
//    }
}

