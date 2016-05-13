package com.example.jakubkalinowski.sharerydeapp;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class RequestARide extends AppCompatActivity {
    Firebase ref = new Firebase("https://shareryde.firebaseio.com/");

    Firebase rootsUserRef;
    ProgressBar progressBar ;
    private Handler handler = new Handler();
    Runnable runnable = null, runnableTimer;
    TextView searching,information;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_aride);

        information = (TextView) findViewById(R.id.informationID);
        searching = (TextView)findViewById(R.id.searchingID);
        progressBar = (ProgressBar) findViewById(R.id.progressID);

        progressBar.setVisibility(View.VISIBLE);

        runnableTimer = new Runnable() {
            @Override
            public void run() {
                progressBar.setVisibility(View.INVISIBLE);
                searching.setVisibility(View.INVISIBLE);
                searchForDrivers();

            }


        };
        handler.postDelayed(runnableTimer, 1000*3);

      //  searchForDrivers();

    }//onCreate

    private void searchForDrivers() {
        // search for drivers near you
        // this will be done by looking at longitude and latitude of drivers.
        //iterate through the list, find the closest driver to user.



        //if match found,
//       if(){
//           displayInformation();
//       }else{
//           information.setText("We're sorry but no drivers were found near you. Please try again later. ");
//       }


    }//serachForDrivers
    private void displayInformation() {

    }



//    public void saveReview(){
//        rootsUserRef = ref.child("users");
//        Toast.makeText(getApplicationContext(),"Submit value clicked", Toast.LENGTH_SHORT).show();
//        rootsUserRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                for (DataSnapshot userSnapshot : dataSnapshot.getChildren()){
//                    String currentUserId = userSnapshot.getKey();
//                    if(((String) userSnapshot.child("emailAddress").getValue())!=null){
//
//                    }
//                    if(((String) userSnapshot.child("emailAddress").getValue()).equals("bambolio@aol.com")){
//                        Map<String, String> reviewMap = new HashMap<String, String>();
//                        reviewMap.put("review",driversReview);
//                        rootsUserRef.child(currentUserId).child("reviews").push().setValue(reviewMap);
//
//                    }
//                }
//            }

          
//            public void onCancelled(FirebaseError firebaseError) {
//
//            }
//        });
}
