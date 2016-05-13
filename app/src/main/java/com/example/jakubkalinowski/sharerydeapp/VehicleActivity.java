package com.example.jakubkalinowski.sharerydeapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class VehicleActivity extends AppCompatActivity {

    Firebase ref = new Firebase("https://shareryde.firebaseio.com/");
    Firebase vehicleRef;
    private EditText mEditVehicle;
    private TextView mFetchVehicle;
    private Button mSubmitButton;
    private String userVehicle;

    String userID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle);
        Firebase.setAndroidContext(this);

        mSubmitButton = (Button)findViewById(R.id.submitButton);
        mEditVehicle = (EditText)findViewById(R.id.newVehicle);
        mFetchVehicle = (TextView)findViewById(R.id.fetchedVehicleText);



        /**
         * Action for mFetchVehicle
         */


        /**
         * Action for 'mSubmitButton'
         *
         */
        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent i = new Intent(VehicleActivity.this, MainActivity.class);
//                startActivity(i);

                saveVehicle();

            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();

        userID = ref.getAuth().getUid();

        final Firebase vehicleRef = ref.child("users").child((String) userID).child("vehicle");

        vehicleRef.addChildEventListener(new ChildEventListener() {

            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String vehicle = dataSnapshot.getValue().toString();
                mFetchVehicle.setText(vehicle);
                System.out.print(mFetchVehicle);

                System.out.print("Fuck me I haent had it in a while");
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                String vehicle = dataSnapshot.getValue().toString();
                mFetchVehicle.setText(vehicle);
                System.out.print(mFetchVehicle);

                System.out.print("Fuck me I haent had it in a while");
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                String vehicle = dataSnapshot.getValue().toString();
                mFetchVehicle.setText(vehicle);
                System.out.print(mFetchVehicle);

                System.out.print("Fuck me I haent had it in a while");
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
                String vehicle = dataSnapshot.getValue().toString();
                mFetchVehicle.setText(vehicle);
                System.out.print(mFetchVehicle);

                System.out.print("Fuck me I haent had it in a while");
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                System.out.println("The read failed: " + firebaseError.getMessage());

            }
        });

        vehicleRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String vehicle = dataSnapshot.getValue().toString();
                mFetchVehicle.setText(vehicle);
                System.out.print(mFetchVehicle);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                System.out.println("The read failed: " + firebaseError.getMessage());
            }
        });
    }

    public void saveVehicle(){

        userID = ref.getAuth().getUid();
        Toast.makeText(getApplicationContext(), "saveVehicle", Toast.LENGTH_LONG).show();

        vehicleRef = ref.child("users").child((String) userID).child("vehicle");
        userVehicle = mEditVehicle.getText().toString();


        vehicleRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot vehicleSnapshot : dataSnapshot.getChildren()){
                    vehicleRef.setValue(userVehicle);

                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
             }
        });

    }
}
//
//    public void saveReview(){
//        rootsUserRef = ref.child("users");
//        Toast.makeText(getApplicationContext(),"Submit value clicked", Toast.LENGTH_SHORT).show();
//        rootsUserRef.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                for (DataSnapshot userSnapshot : dataSnapshot.getChildren()){
//                    String currentUserId = userSnapshot.getKey();
//                    String currentUserEmail="";
//                    if(((String) userSnapshot.child("emailAddress").getValue())!=null){
//                        currentUserEmail = (String) userSnapshot.child("emailAddress").getValue();
//                    }
//                    if(currentUserEmail.equals(driversEmailAddress)){
//                        Map<String, String> reviewMap = new HashMap<String, String>();
//                        reviewMap.put("review",driversReview);
//                        rootsUserRef.child(currentUserId).child("reviews").push().setValue(reviewMap);
//                    }
//                }
//            }
//            @Override
//            public void onCancelled(FirebaseError firebaseError) {
//            }
//        });
