package com.example.jakubkalinowski.sharerydeapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.firebase.client.AuthData;
import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class PaymentActivity extends AppCompatActivity {

    //Firebase Reference
    Firebase wRootRef;
    Firebase ref = new Firebase("https://shareryde.firebaseio.com/");
    Firebase usersRef = ref.child("users");
    AuthData authData;
    String userID; // = ref.getAuth().getUid();

    //variables for all the components of the activity
    private EditText mEmailAddress;
    private EditText paymentAmount;
    private TextView userMoney;
    private Button submitPayment;
    private Button addCredit;
    private Button reedeemCredit;

    private String email;
    private String driverWallet;
    private String driverID;
    private boolean findUser = true;
    //variables for extracting values from components
    private String driversEmailInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        Firebase.setAndroidContext(this);

        wRootRef = new Firebase("https://shareryde.firebaseio.com");

        userMoney = (TextView)findViewById(R.id.userMoney);
        mEmailAddress = (EditText) findViewById(R.id.emailAddress);
        paymentAmount = (EditText) findViewById(R.id.paymentAmount);
        submitPayment = (Button) findViewById(R.id.subPayButton);
    }

    @Override
    protected void onStart() {
        super.onStart();

        authData = ref.getAuth();
        userID = wRootRef.getAuth().getUid();

        final Firebase walletRef = wRootRef.child("users").child((String)userID).child("wallet");//.child(userID);

        /**
         * TO DO: import user's money amount from firebase
         */
        walletRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String wallet = dataSnapshot.getValue(String.class);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                String wallet = dataSnapshot.getValue(String.class);
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                String wallet = dataSnapshot.getValue(String.class);
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
                String wallet = dataSnapshot.getValue(String.class);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                System.out.println("The read failed: " + firebaseError.getMessage());

            }
        });

        walletRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                /*
                This is for a single value like users --> messages (only one child)
                 */
                String wallet = dataSnapshot.getValue().toString();
                userMoney.setText(wallet);
                /******/

                /*
                Map is for object with more than one child
                 */
//                Map<String, String> map = dataSnapshot.getValue(Map.class);
//                String wallet = map.get("wallet");
                /******/
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        Firebase eRootRef = wRootRef.child("users");//.child(userID);


        submitPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                /**
                 * get the amount entered and subtract it from the user then update the user wallet.(do this to passenger only, not the driver)
                 */
                Firebase driverRef = wRootRef.child("users");//

                if (checkValue() == false) {
                    System.out.println("");
                    return;
                }
                else {

                    Double userWallet = Double.parseDouble(usersRef.child(userID).child("wallet").getKey().toString());
                    Double driverWallet = Double.parseDouble(usersRef.child(driverID).child("wallet").getKey().toString());
                    Double hold;

                    userWallet = userWallet - Double.parseDouble(paymentAmount.getText().toString());
                    driverWallet = driverWallet - Double.parseDouble(paymentAmount.getText().toString());

                    ref.child("users").child(userID).child("wallet").setValue(userWallet.toString());
                    ref.child("users").child(driverID).child("wallet").setValue(driverWallet.toString());
                }
                ;
//
//                double dCredit = Double.parseDouble(driversCredit);
//                double pCredit = 0;

                String amount = "";



                Intent i = new Intent(PaymentActivity.this, PaymentActivity.class);
                startActivity(i);
            }

            private boolean checkValue() {
                email = mEmailAddress.getText().toString();

                findUser(); //Check if user is in database

                if (mEmailAddress.getText().toString().isEmpty()) {

                    return false;
                } else if(findUser){
                    findUser = true;
                    return false;
                }
                else if(paymentAmount.getText().toString().isEmpty()){

                    return false;
                }



                return true;
            }

            private void findUser(){
                Firebase rootsUserRef = ref.child("users");



                rootsUserRef.addListenerForSingleValueEvent(new ValueEventListener() {

                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        for (DataSnapshot userSnapshot : dataSnapshot.getChildren()){
                            //String currentUserId = userSnapshot.getKey();
                            String tempEmail = "";
                            driverID = userSnapshot.getKey();
                            if(((String) userSnapshot.child("emailAddress").getValue())!=null){
                                tempEmail = (String) userSnapshot.child("emailAddress").getValue();
                                System.out.println(tempEmail);
                            }
                            // System.out.println("ITS JSON");
                            //System.out.println(email + "::" + userSnapshot.child("emailAddress").getValue().toString());
                            if(tempEmail.equals(email)){
                                driverWallet = userSnapshot.child("wallet").getValue().toString();
                                findUser = false;

                            }
                            else{
                                driverID = "";
                                driverWallet = "";
                            }
                        }
                    }

                    @Override
                    public void onCancelled(FirebaseError firebaseError) {

                    }
                });


            }


        });


    }


}