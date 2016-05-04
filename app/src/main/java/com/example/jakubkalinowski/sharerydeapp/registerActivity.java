package com.example.jakubkalinowski.sharerydeapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.Map;
import java.util.regex.Pattern;

public class registerActivity extends AppCompatActivity {

    //Firebase Reference
    Firebase ref = new Firebase("https://shareryde.firebaseio.com/");


    //variables for all the components of the activity
    private EditText mFullName;
    private EditText mEmailAddress;
    private EditText mPassword;
    private EditText mRepeatPassword;
    private EditText mAddress;
    private EditText mVehicle;
    private EditText mSeatsAmount;
//    private EditText mMondayA;
//    private EditText mMondayD;
//    private EditText mTuesdayA;
//    private EditText mTuesdayD;
//    private EditText mWednesdayA;
//    private EditText mWednesdayD;
//    private EditText mThursdayA;
//    private EditText mThursdayD;
//    private EditText mFridayA;
//    private EditText mFridayD;
    private Button mSignUpButton;

    //variables for extracting values from components
    private String fullNameInput;
    private String emailInput;
    private String passwordInput;
    private String repeatPasswordInput;
    private String addressInput;
    private String vehicleInput;
    private String seatsAmountInput;
//    private int mondayAInput;
//    private int mondayDInput;
//    private int tuesdayAInput;
//    private int tuesdayDInput;
//    private int wednesdayAInput;
//    private int wednesdayDInput;
//    private int thursdayAInput;
//    private int thursdayDInput;
//    private int fridayAInput;
//    private int fridayDInput;
    private String statusCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        //this part is for hint animation
        TextInputLayout fullNameWrapper = (TextInputLayout) findViewById(R.id.fullName_textInput);
        TextInputLayout emailAddressWrapper = (TextInputLayout) findViewById(R.id.email_address_text_input);
        TextInputLayout passwordWrapper = (TextInputLayout) findViewById(R.id.password_textInput);
        TextInputLayout repeatPasswordWrapper = (TextInputLayout) findViewById(R.id.repeat_password_textInput);
        TextInputLayout addressWrapper = (TextInputLayout) findViewById(R.id.address_textInput);
        TextInputLayout vehicleWrapper = (TextInputLayout) findViewById(R.id.vehicleTextInput);
//        TextInputLayout mondayAWrapper = (TextInputLayout) findViewById(R.id.mondayATextInput);
//        TextInputLayout mondayDWrapper = (TextInputLayout) findViewById(R.id.mondayDTextInput);
//        TextInputLayout tuesdayAWrapper = (TextInputLayout) findViewById(R.id.tuesdayATextInput);
//        TextInputLayout tuesdayDWrapper = (TextInputLayout) findViewById(R.id.tuesdayDTextInput);
//        TextInputLayout wednesdayAWrapper = (TextInputLayout) findViewById(R.id.wednesdayATextInput);
//        TextInputLayout wednesdayDWrapper = (TextInputLayout) findViewById(R.id.wednesdayDTextInput);
//        TextInputLayout thursdayAWrapper = (TextInputLayout) findViewById(R.id.thursdayATextInput);
//        TextInputLayout thursdayDWrapper = (TextInputLayout) findViewById(R.id.thursdayDTextInput);
//        TextInputLayout fridayAWrapper = (TextInputLayout) findViewById(R.id.fridayATextInput);
//        TextInputLayout fridayDWrapper = (TextInputLayout) findViewById(R.id.fridayDTextInput);
        TextInputLayout seatsAmountWrapper = (TextInputLayout) findViewById(R.id.seatesAmountTextInput);

        fullNameWrapper.setHint("Full Name");
        emailAddressWrapper.setHint("Email Address");
        passwordWrapper.setHint("Password");
        repeatPasswordWrapper.setHint("Repeat Password");
        addressWrapper.setHint("Address (Street, City, State, Zip Code");
        vehicleWrapper.setHint("Vehicle (Year, Make, Model, Color");
        seatsAmountWrapper.setHint("Amount of seats in the vehicle");
//        mondayAWrapper.setHint("Time you need to be at school");
//        mondayDWrapper.setHint("Time you need to leave school");
//        tuesdayAWrapper.setHint("Time you need to be at school");
//        tuesdayDWrapper.setHint("Time you need to leave school");
//        wednesdayAWrapper.setHint("Time you need to be at school");
//        wednesdayDWrapper.setHint("Time you need to leave school");
//        thursdayAWrapper.setHint("Time you need to be at school");
//        thursdayDWrapper.setHint("Time you need to leave school");
//        fridayAWrapper.setHint("Time you need to be at school");
//        fridayDWrapper.setHint("Time you need to leave school");

    }

    @Override
    protected void onStart() {
        super.onStart();
        Firebase.setAndroidContext(this);

        //initializing activity components
        mFullName = (EditText) findViewById(R.id.fullName);
        mEmailAddress = (EditText) findViewById(R.id.email_address);
        mPassword = (EditText) findViewById(R.id.password);
        mRepeatPassword = (EditText) findViewById(R.id.repeat_password);
        mAddress = (EditText) findViewById(R.id.address);
        mVehicle = (EditText) findViewById(R.id.vehicle);
        mSeatsAmount = (EditText) findViewById(R.id.seatsAmount);
        mSignUpButton = (Button) findViewById(R.id.sign_up_button_register_activity);
//        mMondayA = (EditText) findViewById(R.id.mA);
//        mMondayD = (EditText) findViewById(R.id.mD);
//        mTuesdayA = (EditText) findViewById(R.id.tA);
//        mTuesdayD = (EditText) findViewById(R.id.tD);
//        mWednesdayA = (EditText) findViewById(R.id.wA);
//        mWednesdayD = (EditText) findViewById(R.id.wD);
//        mThursdayA = (EditText) findViewById(R.id.thA);
//        mThursdayD = (EditText) findViewById(R.id.thD);
//        mFridayA = (EditText) findViewById(R.id.fA);
//        mFridayD = (EditText) findViewById(R.id.fD);
        statusCheck = "passenger";



        /**
         * Action for 'mSignUpButton'
         * mFirstName, mLastName etc. and Firebase will be dealt with here
         */

        mSignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /**
                 * TASKS TO BE COMPLETED
                 * - implement password checker
                 * - implement regex checker
                 * - implement exisisting usernames checker
                 * -
                 */

                Toast.makeText(getApplicationContext(), "SIGN UP Button is clicked", Toast.LENGTH_LONG).show();

                Boolean isExistingUsername = false;
                fullNameInput = mFullName.getText().toString();
                emailInput = mEmailAddress.getText().toString();
                passwordInput = mPassword.getText().toString();
                repeatPasswordInput = mRepeatPassword.getText().toString();
                addressInput = mAddress.getText().toString();
                vehicleInput = mVehicle.getText().toString();
                seatsAmountInput = mSeatsAmount.getText().toString();
//                arrivals =

                final User newUser = new User(fullNameInput, emailInput, passwordInput, addressInput, vehicleInput, seatsAmountInput, statusCheck);

                ref.createUser(newUser.getEmailAddress(), newUser.getPassword(), new Firebase.ValueResultHandler<Map<String, Object>>() {
                    @Override
                    public void onSuccess(Map<String, Object> result) {
                        Toast.makeText(getApplicationContext(), "account created", Toast.LENGTH_LONG).show();

                        /**
                         * backup method if boolean throws issues
                         Map <String, String> newUserMap = new HashMap<String, String>();
                         newUserMap.put("firstName", newUser.getFirstName());
                         newUserMap.put("lastName", newUser.getLastName());
                         newUserMap.put("emailAddress", newUser.getEmailAddress());
                         newUserMap.put(,"password", newUser.getPassword());
                         newUserMap.put("address", newUser.getAddress());
                         newUserMap.put("driver", newUser.getDriver().toString());
                         ref.child("users").child((String) result.get("uid")).setValue(newUserMap);
                         *
                         */



                        ref.child("users").child((String) result.get("uid")).setValue(newUser);

                        Snackbar snackbar = Snackbar.make((LinearLayout) findViewById(R.id.sign_up_layout_id), "Profile Created", Snackbar.LENGTH_LONG);
                        snackbar.show();

                    }

                    @Override
                    public void onError(FirebaseError firebaseError) {

                        Log.e("ERROR TAG", "didnt work but got through firebase reference!!!: " + emailInput);
                    }
                });

                // register button transfers to main screen
                Intent i = new Intent(registerActivity.this, MainActivity.class);
                //i.putExtra("firebaseURL", "https://allmythings2016.firebaseio.com/");
//                i.putExtra("userEmail", email);
                startActivity(i);


            }
        });


    }

    /**
     * To check if user enters and confirms his/her password
     *
     * @param password
     * @param repeatPassword
     * @return boolean checking both passwords match for confirmation
     */
    public boolean checkPassWordAndConfirmPassword(String password, String repeatPassword) {
        boolean pstatus = false;
        if (repeatPassword != null && password != null) {
            if (password.equals(repeatPassword)) {
                pstatus = true;
            }
        }
        return pstatus;
    }

    /**
     * To check email confirming email pattern
     *
     * @param email
     * @return boolean checking email validation
     */
    private boolean isValidEmail(String email) {
        Pattern pattern = Patterns.EMAIL_ADDRESS;
        return pattern.matcher(email).matches();
    }
}