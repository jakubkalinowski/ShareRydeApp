package com.example.jakubkalinowski.sharerydeapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class ReviewActivity extends AppCompatActivity {


    Firebase ref = new Firebase("https://shareryde.firebaseio.com/");
    private EditText mEmailAddressEditText;
    private EditText mReviewEditText;
    private Button mButton;
    private String driversEmailAddress;
    private String driversReview;
    private Firebase rootsUserRef;

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
                driversReview = mReviewEditText.getText().toString();
                driversEmailAddress = mEmailAddressEditText.getText().toString();
                saveReview();
                Intent i = new Intent(ReviewActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
    }

    public void saveReview(){
        rootsUserRef = ref.child("users");
        Toast.makeText(getApplicationContext(),"Submit value clicked", Toast.LENGTH_SHORT).show();
        rootsUserRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot userSnapshot : dataSnapshot.getChildren()){
                    String currentUserId = userSnapshot.getKey();
                    String currentUserEmail="";
                    if(((String) userSnapshot.child("emailAddress").getValue())!=null){
                        currentUserEmail = (String) userSnapshot.child("emailAddress").getValue();
                        System.out.println(currentUserEmail);
                    }
                    if(currentUserEmail.equals(driversEmailAddress)){
                        Map<String, String> reviewMap = new HashMap<String, String>();
                        reviewMap.put("review",driversReview);
                        rootsUserRef.child(currentUserId).child("reviews").push().setValue(reviewMap);

                    }
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

    }


}
