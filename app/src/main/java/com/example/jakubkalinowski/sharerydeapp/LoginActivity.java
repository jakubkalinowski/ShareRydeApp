package com.example.jakubkalinowski.sharerydeapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.AuthData;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity {

    //Firebase Reference
    Firebase ref = new Firebase("https://shareryde.firebaseio.com/");

    //variables for all the components of the activity
    private EditText mEmailAddress;
    private EditText mPassword;
    private Button mSignInButton;
    private Button mRegisterButton;

    //variables for extracting values from components
    private String emailInput;
    private String passwordInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        TextInputLayout emailAddressWrapper = (TextInputLayout) findViewById(R.id.email_wrapper_login_activity);
        TextInputLayout passwordWrapper = (TextInputLayout) findViewById(R.id.password_wrapper_login_activity);
        emailAddressWrapper.setHint("Email");
        passwordWrapper.setHint("Password");
        Firebase.setAndroidContext(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Firebase.setAndroidContext(this);
        mEmailAddress = (EditText)findViewById(R.id.email_text_input_login_activity);
        mPassword = (EditText)findViewById(R.id.password_textInput_login_activity);
        mSignInButton = (Button) findViewById(R.id.sign_in_button_login_activity);
        mRegisterButton = (Button) findViewById(R.id.register_button_login_activity);

        mSignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email = mEmailAddress.getText().toString();
                String password = mPassword.getText().toString();

                ref.authWithPassword(email, password, new Firebase.AuthResultHandler() {

                    @Override
                    public void onAuthenticated(AuthData authData) {
                        Log.d("LOGIN TAG!!!!!!!", "User ID: " + authData.getUid() + ", Provider: " + authData.getProvider());
                        Toast.makeText(getApplicationContext(), "LOG IN SUCCESSFUL!!!!", Toast.LENGTH_LONG).show();

                        //storing user data
//                        Map<String, String> map = new HashMap<String, String>();
//                        map.put("provider", authData.getProvider());
//                        if (authData.getProviderData().containsKey("displayName")) {
//                            map.put("displayName", authData.getProviderData().get("displayName").toString());
//                        }
//                        FBref.child("users").child(authData.getUid()).setValue(map);
                        //

                        Intent i = new Intent(LoginActivity.this, MainActivity.class);
                        i.putExtra("userEmail", email);
                        startActivity(i);
                    }

                    @Override
                    public void onAuthenticationError(FirebaseError firebaseError) {
                        // there was an error
                        Toast.makeText(getApplicationContext(), "LOG IN UNSUCCESSFUL!!!!", Toast.LENGTH_LONG).show();
                        Log.e("ERROR TAG", "didnt work but got through firebase reference!!!: ");
                    }
                });
            }

        });

        mRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startSignUp = new Intent(LoginActivity.this, registerActivity.class);
                startActivity(startSignUp);
            }
        });

    }
}

