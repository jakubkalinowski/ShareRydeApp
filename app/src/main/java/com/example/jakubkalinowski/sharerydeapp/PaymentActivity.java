package com.example.jakubkalinowski.sharerydeapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.firebase.client.Firebase;

public class PaymentActivity extends AppCompatActivity {

    //Firebase Reference
    Firebase ref = new Firebase("https://shareryde.firebaseio.com/");


    //variables for all the components of the activity
    private EditText mEmailAddress;
    private EditText paymentAmount;
    private TextView userMoney;
    private Button submitPayment;
    private Button addCredit;
    private Button reedeemCredit;

    //variables for extracting values from components
    private String driversEmailInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        /**
         * TO DO: import user's money amount from firebase
         */
    }

    @Override
    protected void onStart() {
        super.onStart();
        Firebase.setAndroidContext(this);

        //initializing activity components
        mEmailAddress = (EditText) findViewById(R.id.emailAddress);
        paymentAmount = (EditText) findViewById(R.id.paymentAmount);
        userMoney = (TextView) findViewById(R.id.userMoney);
        submitPayment = (Button) findViewById(R.id.subPayButton);
        addCredit = (Button) findViewById(R.id.addCreditButton);
        reedeemCredit = (Button) findViewById(R.id.reedeemCreditButton);

        /**
         * Action for 'submitPayment'
         * Calculations and Firebase will be dealt with here
         */

        submitPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /**
                 * TO DO: take the ures money reference and subtract the payment amount from it
                 *          and store it back in the db
                 */


                /**
                 * TO DO: fetch driver money amount from db, add the payment amount to it and store it back in the db
                 */
            }
        });
    }
}
