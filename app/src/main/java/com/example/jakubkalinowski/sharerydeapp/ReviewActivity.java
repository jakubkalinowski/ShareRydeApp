package com.example.jakubkalinowski.sharerydeapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.firebase.client.Firebase;

public class ReviewActivity extends AppCompatActivity {


    Firebase ref = new Firebase("https://shareryde.firebaseio.com/");
    private EditText mEmailAddressEditText;
    private EditText mReviewEditText;
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Firebase.setAndroidContext(this);
        mEmailAddressEditText = (EditText) findViewById(R.id.emailAddress_review_editText);
        mReviewEditText = (EditText) findViewById(R.id.leaveReview_review_editText);
        mButton = (Button) findViewById(R.id.submit_review_button);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ReviewActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

    }
}
