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
import android.widget.CheckBox;
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
    private EditText mFirstName;
    private EditText mLastName;
    private EditText mEmailAddress;
    private EditText mPassword;
    private EditText mRepeatPassword;
    private EditText mAddress;
    private CheckBox mDriver;
    private Button mSignUpButton;

    //variables for extracting values from components
    private String firstNameInput;
    private String lastNameInput;
    private String emailInput;
    private String passwordInput;
    private String repeatPasswordInput;
    private String addressInput;
    private Boolean driver;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        //this part is for hint animation
        TextInputLayout firstNameWrapper = (TextInputLayout) findViewById(R.id.first_name_textInput);
        TextInputLayout lastNameWrapper = (TextInputLayout) findViewById(R.id.last_name_textInput);
        TextInputLayout emailAddressWrapper = (TextInputLayout) findViewById(R.id.email_address_text_input);
        TextInputLayout passwordWrapper = (TextInputLayout) findViewById(R.id.password_textInput);
        TextInputLayout repeatPasswordWrapper = (TextInputLayout) findViewById(R.id.repeat_password_textInput);
        TextInputLayout addressWrapper = (TextInputLayout) findViewById(R.id.address_textInput);
        firstNameWrapper.setHint("First Name");
        lastNameWrapper.setHint("Last Name");
        emailAddressWrapper.setHint("Email Address");
        passwordWrapper.setHint("Password");
        repeatPasswordWrapper.setHint("Repeat Password");
        addressWrapper.setHint("Address");

    }

    @Override
    protected void onStart() {
        super.onStart();
        Firebase.setAndroidContext(this);

        //initializing activity components
        mFirstName = (EditText) findViewById(R.id.first_name);
        mLastName = (EditText) findViewById(R.id.last_name);
        mEmailAddress = (EditText) findViewById(R.id.email_address);
        mPassword = (EditText) findViewById(R.id.password);
        mRepeatPassword = (EditText) findViewById(R.id.repeat_password);
        mAddress = (EditText) findViewById(R.id.address);
        mDriver = (CheckBox) findViewById(R.id.driver_checkbox);
        mSignUpButton = (Button) findViewById(R.id.sign_up_button_register_activity);

        //setting hints for animation


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
                firstNameInput = mFirstName.getText().toString();
                lastNameInput = mLastName.getText().toString();
                emailInput = mEmailAddress.getText().toString();
                passwordInput = mPassword.getText().toString();
                repeatPasswordInput = mRepeatPassword.getText().toString();
                addressInput = mAddress.getText().toString();
                driver = mDriver.isChecked();


                final User newUser = new User(firstNameInput,lastNameInput,emailInput, passwordInput, addressInput, driver);

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